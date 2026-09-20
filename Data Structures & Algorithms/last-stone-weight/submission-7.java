class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s:stones){
            pq.offer(-s);
        }
        while(!(pq.size()<=1)){
            int first=pq.poll();
            int second=pq.poll();
            if(first<second){
                pq.offer(first-second);
            }
        }
        return pq.isEmpty()?0:-pq.peek();
    }
}

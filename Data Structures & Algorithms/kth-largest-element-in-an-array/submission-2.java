class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> mp=new PriorityQueue<>();
        for(int num:nums){
            mp.offer(num);
            if(mp.size()>k) mp.poll();
        }
        return mp.peek();
    }
}

class KthLargest {
    private PriorityQueue<Integer> pq;
    int a;
    public KthLargest(int k, int[] nums) {
        a=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>a) pq.poll();
        return pq.peek();
    }
}

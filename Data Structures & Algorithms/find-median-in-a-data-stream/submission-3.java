class MedianFinder {
    private Queue<Integer> sh;
    private Queue<Integer> lh;
    public MedianFinder() {
        sh=new PriorityQueue<>((a,b)->b-a);
        lh=new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        sh.add(num);
        lh.offer(sh.poll());
        if(lh.size()>sh.size()){
            sh.offer(lh.poll());
        }
    }
    
    public double findMedian() {
        if(sh.size()==lh.size()){
            return (double)(sh.peek()+lh.peek())/2.0;
        }else{
            return sh.peek();
        }
    }
}

class MedianFinder {
    PriorityQueue<Integer> sh;
    PriorityQueue<Integer> lh;
    public MedianFinder() {
        sh=new PriorityQueue<>(Comparator.reverseOrder());
        lh=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        sh.offer(num);
        lh.offer(sh.poll());
        if(lh.size()>sh.size()){
            sh.offer(lh.poll());
        }
    }
    
    public double findMedian() {
        if(lh.size()==sh.size()){
            return (double)(lh.peek()+sh.peek())/2.0;
        }else{
            return (double)sh.peek();
        }
    }
}

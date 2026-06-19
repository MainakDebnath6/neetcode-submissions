class MedianFinder {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        largeHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        smallHeap.offer(num);

        if (!largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()) {
            largeHeap.offer(smallHeap.poll());
        }

        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.offer(smallHeap.poll());
        }

        if (largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }

        return smallHeap.size() > largeHeap.size()
                ? smallHeap.peek()
                : largeHeap.peek();
    }
}
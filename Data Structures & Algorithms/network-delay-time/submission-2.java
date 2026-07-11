class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> edges=new HashMap<>();
        for(int[] time:times){
            edges.computeIfAbsent(time[0],
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,k});
        int t=0;
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int w1=curr[0];
            int n1=curr[1];
            if(visited.contains(n1)) continue;
            visited.add(n1);
            t=w1;
            if(edges.containsKey(n1)){
                for(int[] p:edges.get(n1)){
                    int w2=p[1];
                    int n2=p[0];
                    if(visited.contains(n2)) continue;
                    minHeap.add(new int[]{w1+w2,n2});
                }
            }
        }
        return visited.size()==n?t:-1;
    }
}

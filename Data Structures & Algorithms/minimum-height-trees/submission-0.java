class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(n<=0) return res;
        if(n==1){
            res.add(0);
            return res;
        }
        int[] indegree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1) q.offer(i);
        }
        while(n>2){
            int size=q.size();
            n-=size;
            while(size-->0){
                int node=q.poll();
                for(int nei:adj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei]==1) q.offer(nei);
                }
            }
        }
        res.addAll(q);
        return res;
    }
}
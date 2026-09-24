class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] visited=new boolean[n];
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int node=0,edges=0,res=0;
        while(edges<n-1){
            visited[node]=true;
            int nextNode=-1;
            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                int curDist=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
                dist[i]=Math.min(dist[i],curDist);
                if(nextNode==-1 || dist[i]<dist[nextNode]){
                    nextNode=i;
                }
            }
            res+=dist[nextNode];
            edges++;
            node=nextNode;
        }
        return res;
    }
}

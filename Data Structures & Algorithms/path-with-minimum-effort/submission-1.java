class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        ROWS=heights.length;
        COLS=heights[0].length;
        int[] dist=new int[ROWS*COLS];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        boolean[] inQueue=new boolean[ROWS*COLS];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        inQueue[0]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            inQueue[u]=false;
            int r=u/COLS,c=u%COLS;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS){
                    int v=nr*COLS+nc;
                    int weight=Math.abs(heights[r][c]-heights[nr][nc]);
                    int newDist=Math.max(dist[u],weight);
                    if(newDist<dist[v]){
                        dist[v]=newDist;
                        if(!inQueue[v]){
                            q.offer(v);
                            inQueue[v]=true;
                        }
                    }
                }
            }
        }
        return dist[ROWS*COLS-1];
    }
}
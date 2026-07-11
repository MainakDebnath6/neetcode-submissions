class Solution {
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int N=grid.length;
        boolean[][] visited=new boolean[N][N];
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        q.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            int t=p[0],r=p[1],c=p[2];
            if(r==N-1 && c==N-1) return t;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.offer(new int[]{Math.max(t,grid[nr][nc]),nr,nc});
                }
            }
        }
        return N*N;
    }
}

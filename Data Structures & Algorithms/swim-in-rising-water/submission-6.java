class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;
    public int swimInWater(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b)->Integer.compare(a[0], b[0]));
        boolean[][] visited=new boolean[ROWS][COLS];
        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int t=p[0];
            int r=p[1];
            int c=p[2];
            if(r==ROWS-1 && c==COLS-1) return t;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    pq.offer(new int[]{Math.max(grid[nr][nc],t),nr,nc});
                }
            }
        }
        return -1;
    }
}

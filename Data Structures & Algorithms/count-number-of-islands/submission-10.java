class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        int islands=0;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid,int r,int c){
        grid[r][c]='0';
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            for(int[] d:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc]=='1'){
                    grid[nr][nc]='0';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}

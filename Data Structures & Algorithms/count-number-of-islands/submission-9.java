class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        int islands=0;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    bfs(r,c,grid);
                }
            }
        }
        return islands;
    }
    private void bfs(int r,int c,char[][] grid){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
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

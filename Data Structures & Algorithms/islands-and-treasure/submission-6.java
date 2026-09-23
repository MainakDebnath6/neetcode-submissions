class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            for(int[] d:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc]==2147483647){
                    grid[nr][nc]=grid[row][col]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}

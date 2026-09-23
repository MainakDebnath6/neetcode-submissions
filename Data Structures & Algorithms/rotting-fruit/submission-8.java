class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==1) fresh++;
                else if(grid[r][c]==2) q.offer(new int[]{r,c});
            }
        }
        int time=0;
        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] p=q.poll();
                int row=p[0];
                int col=p[1];
                for(int[] d:dir){
                    int nr=row+d[0];
                    int nc=col+d[1];
                    if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc]==1){
                        fresh--;
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return fresh==0?time:-1;
    }
}

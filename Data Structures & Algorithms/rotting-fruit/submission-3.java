class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int time=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        while(fresh>0 && !q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            for(int[] d:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
            }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}


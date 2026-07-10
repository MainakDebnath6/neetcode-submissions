class Solution {
    Queue<int[]> q=new LinkedList<>();
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.size()==0) return;
        while(!q.isEmpty()){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            for(int[] d:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]!=2147483647){
                    continue;
                }
                q.add(new int[]{nr,nc});
                grid[nr][nc]=grid[row][col]+1;
            }
        }
    }
}

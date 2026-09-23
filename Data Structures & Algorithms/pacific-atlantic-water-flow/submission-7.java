class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS=heights.length;
        COLS=heights[0].length;
        boolean[][] pac=new boolean[ROWS][COLS];
        boolean[][] atl=new boolean[ROWS][COLS];
        for(int i=0;i<ROWS;i++){
            check(i,0,pac,heights);
            check(i,COLS-1,atl,heights);
        }
        for(int j=0;j<COLS;j++){
            check(0,j,pac,heights);
            check(ROWS-1,j,atl,heights);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(atl[i][j] && pac[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void check(int r,int c,boolean[][] ocean,int[][] heights){
        if(ocean[r][c]) return;
        ocean[r][c]=true;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && heights[nr][nc]>=heights[r][c]){
                check(nr,nc,ocean,heights);
            }
        }
    }
}

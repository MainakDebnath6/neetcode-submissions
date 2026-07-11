class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS,COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS=heights.length;
        COLS=heights[0].length;
        if (heights == null || heights.length == 0)
        return new ArrayList<>();
        boolean[][] atl=new boolean[ROWS][COLS];
        boolean[][] pac=new boolean[ROWS][COLS];
        
        for(int r=0;r<ROWS;r++){
            check(r,0,pac,heights);
            check(r,COLS-1,atl,heights);
        }
        for(int c=0;c<COLS;c++){
            check(0,c,pac,heights);
            check(ROWS-1,c,atl,heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(atl[r][c] && pac[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
    private void check(int r,int c,boolean[][] ocean,int[][] heights){
        ocean[r][c]=true;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                check(nr,nc,ocean,heights);
            }
        }
    }
}

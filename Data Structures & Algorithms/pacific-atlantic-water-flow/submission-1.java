class Solution {
    private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    private int ROWS,COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS=heights.length;
        COLS=heights[0].length;
        boolean[][] pac=new boolean[ROWS][COLS];
        boolean[][] atl=new boolean[ROWS][COLS];
        for(int c=0;c<COLS;c++){
            dfs(0,c,pac,heights);
            dfs(ROWS-1,c,atl,heights);
        }
        for(int r=0;r<ROWS;r++){
            dfs(r,0,pac,heights);
            dfs(r,COLS-1,atl,heights);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(atl[r][c] && pac[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    private void dfs(int row,int col, boolean[][] ocean,int[][] heights){
        ocean[row][col]=true;
        for(int[] dir:directions){
            int nr=row+dir[0];
            int nc=col+dir[1];
            if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && !ocean[nr][nc] && heights[nr][nc]>=heights[row][col]){
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}

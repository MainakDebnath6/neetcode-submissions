class Solution {
    int ROWS,COLS;
    int[][] dp;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        ROWS=matrix.length;
        COLS=matrix[0].length;
        int res=0;
        dp=new int[ROWS][COLS];
        int LIP=0;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                dp[i][j]=-1;
            }   
        }
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                LIP=Math.max(LIP,dfs(matrix,i,j,Integer.MIN_VALUE));
            }   
        }
        return LIP;
    }
    private int dfs(int[][] matrix,int r,int c,int prevVal){
        if(r<0 || r>=ROWS || c<0 || c>=COLS || matrix[r][c]<=prevVal) return 0;
        int res=1;
        if(dp[r][c]!=-1) return dp[r][c];
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            res=Math.max(res,1+dfs(matrix,nr,nc,matrix[r][c]));
        }
        return dp[r][c]=res;
    }
}

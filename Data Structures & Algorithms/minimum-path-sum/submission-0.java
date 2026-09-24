class Solution {
    int ROWS,COLS;
    public int minPathSum(int[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        int[][] dp=new int[ROWS+1][COLS+1];
        for(int i=0;i<=ROWS;i++){
            for(int j=0;j<=COLS;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[ROWS-1][COLS]=0;
        for(int i=ROWS-1;i>=0;i--){
            for(int j=COLS-1;j>=0;j--){
                dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
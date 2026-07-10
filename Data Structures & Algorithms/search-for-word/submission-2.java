class Solution {
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private int ROWS,COLS;
    public boolean exist(char[][] board, String word) {
        ROWS=board.length;
        COLS=board[0].length;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(dfs(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,int row,int col,int i){
        if(i==word.length()) return true;
        if(row<0 || col<0 || row>=ROWS || col>=COLS || board[row][col]!=word.charAt(i) || board[row][col]=='#'){
            return false;
        }
        board[row][col]='#';
        for(int[] d:dir){
            if(dfs(board,word,row+d[0],col+d[1],i+1)){
                board[row][col]=word.charAt(i);
                return true;
            }
        }
        board[row][col]=word.charAt(i);
        return false;
    }
}

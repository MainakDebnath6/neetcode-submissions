class Solution {
    private int ROWS, COLS;
    private int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
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
    private boolean dfs(char[][] board, String word,int r,int c,int i){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS ||board[r][c]=='#' || board[r][c]!=word.charAt(i)){
            return false;
        }
        board[r][c]='#';
        for(int[] d:dir){
            if (dfs(board, word,
                    r + d[0], c + d[1], i + 1)) {

                board[r][c] = word.charAt(i);
                return true;
            }
        }
        board[r][c]=word.charAt(i);
        return false;
    }
}

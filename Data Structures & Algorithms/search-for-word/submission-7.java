class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS,COLS;
    public boolean exist(char[][] board, String word) {
        ROWS=board.length;
        COLS=board[0].length;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(dfs(0,r,c,board,word)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int i,int r,int c,char[][] board, String word){
        if(i>=word.length()){
            return true;
        }
        if(r<0 || r>=ROWS || c<0 || c>=COLS || board[r][c]=='#' || board[r][c]!=word.charAt(i)) return false;
        board[r][c]='#';
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(dfs(i+1,nr,nc,board,word)){
                board[r][c]=word.charAt(i);
                return true;
            }
        }
        board[r][c]=word.charAt(i);
        return false;
    }
}

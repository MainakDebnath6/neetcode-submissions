class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        dfs(0,board);
        return res;
    }
    private void dfs(int r,char[][] board){
        if(r>=board.length){
            List<String> copy=new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            res.add(new ArrayList<>(copy));
            return;
        }
        for(int c=0;c<board[0].length;c++){
            board[r][c]='Q';
            if(safe(r,c,board)){
                dfs(r+1,board);
            }
            board[r][c]='.';
        }
    }
    private boolean safe(int r,int c,char[][] board){
        for(int i=r-1;i>=0;i--){
            if(board[i][c]=='Q') return false;
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=r-1,j=c+1;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}

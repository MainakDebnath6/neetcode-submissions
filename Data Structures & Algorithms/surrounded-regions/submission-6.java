class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        ROWS=board.length;
        COLS=board[0].length;
        capture(board);
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void capture(char[][] board){
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if((r==0 || r==ROWS-1 || c==0 || c==COLS-1) && board[r][c]=='O'){
                    q.offer(new int[]{r,c});
                }   
            }
        }
        while(!q.isEmpty()){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            board[row][col]='T';
            for(int[] d:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && board[nr][nc]=='O'){
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}

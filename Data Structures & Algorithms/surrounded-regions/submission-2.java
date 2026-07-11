class Solution {
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS,COLS;
    public void solve(char[][] board) {
        ROWS=board.length;
        COLS=board[0].length;
        capture(board);
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
                if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
        }
    }
    private void capture(char[][] board){
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if((r==0 || r==ROWS-1 || c==0 || c==COLS-1)&&board[r][c]=='O'){
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

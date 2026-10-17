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
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if((i==0 || i==ROWS-1 || j==0 || j==COLS-1) && board[i][j]=='O'){
                    board[i][j]='T';
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p=q.poll();
            int r=p[0];
            int c=p[1];
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && board[nr][nc]=='O'){
                    board[nr][nc]='T';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}

class DSU {
    int[] Parent, Size;
    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }
    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return false;
        if (Size[pu] >= Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        } else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        return true;
    }
    public int getSize(int node) {
        return Size[find(node)];
    }
}

class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS,COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        DSU dsu = new DSU(ROWS * COLS);
        int maxi=0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1){
                    for(int[] d:dir){
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc]==1){
                            dsu.union(r*COLS+c,nr*COLS+nc);
                        }
                    }
                    maxi=Math.max(maxi,dsu.getSize(r*COLS+c));
                }
                
            }
        }
        return maxi;
    }
}

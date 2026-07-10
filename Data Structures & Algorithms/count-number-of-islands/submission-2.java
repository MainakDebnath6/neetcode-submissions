class DSU{
    private int[] Parent,Size;
    public DSU(int n){
        Parent=new int[n+1];
        Size=new int[n+1];
        for(int i=0;i<=n;i++){
            Parent[i]=i;
            Size[i]=1;
        }
    }
    public int find(int node){
        if(node!=Parent[node]){
            Parent[node]=find(Parent[node]);
        }
        return Parent[node];
    }
    public boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return false;
        if(Size[pu]>=Size[pv]){
            Size[pu]+=Size[pv];
            Parent[pv]=pu;
        }else{
            Size[pv]+=Size[pu];
            Parent[pu]=pv;
        }
        return true;
    }
}
class Solution {
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private int islands=0;
    public int numIslands(char[][] grid) {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        DSU dsu=new DSU(ROWS*COLS);
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    for(int[] d:dir){
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nc>=0 && nr<ROWS && nc<COLS && grid[nr][nc]=='1'){
                            if(dsu.union(r*COLS+c,nr*COLS+nc)){
                                islands--;
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}

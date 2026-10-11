class DSU{
    int[] Parent,Size;
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
    public int getSize(int node){
        return Size[find(node)];
    }
}
class Solution {
    int ROWS,COLS;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        int res=0;
        DSU dsu=new DSU(ROWS*COLS-1);
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]==1){
                    for(int[] d:dir){
                        int nr=i+d[0];
                        int nc=j+d[1];
                        if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc]==1){
                            dsu.union(i*COLS+j,nr*COLS+nc);
                        }
                    }
                    res=Math.max(res,dsu.getSize(i*COLS+j));
                }
                
            }
        }
        return res;
    }
}

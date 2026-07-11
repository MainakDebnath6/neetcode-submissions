class DSU{
    private int[] Parent,Size;
    private int comps;
    public DSU(int n){
        comps=n;
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
        comps--;
        if(Size[pu]>=Size[pv]){
            Size[pu]+=Size[pv];
            Parent[pv]=pu;
        }else{
            Size[pv]+=Size[pu];
            Parent[pu]=pv;
        }
        return true;
    }
    public int comps(){
        return comps;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1) return false;
        DSU dsu=new DSU(n);
        for(int[] edge:edges){
            if(!dsu.union(edge[0],edge[1])) return false;
        }
        return dsu.comps()==1;
    }
}

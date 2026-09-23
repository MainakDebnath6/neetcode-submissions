class DSU{
    int[] Parent,Size;
    int comps;
    public DSU(int n){
        Parent=new int[n+1];
        Size=new int[n+1];
        comps=n;
        for(int i=0;i<=n;i++){
            Parent[i]=i;
            Size[i]=1;
        }
    }
    public int find(int node){
        if(Parent[node]!=node){
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
        comps--;
        return true;
    }
    public int getComps(){
        return comps;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu=new DSU(n);
        for(int[] edge:edges){
            if(!dsu.union(edge[0],edge[1])) return false;
        }
        return dsu.getComps()==1;
    }
}

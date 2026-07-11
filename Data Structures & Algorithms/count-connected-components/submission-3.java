class DSU{
    int[] Parent,Rank;
    public DSU(int n){
        Parent=new int[n+1];
        Rank=new int[n+1];
        for(int i=0;i<=n;i++){
            Parent[i]=i;
            Rank[i]=1;
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
        if(Rank[pv]>Rank[pu]){
            int tmp=Rank[pv];
            Rank[pv]=Rank[pu];
            Rank[pu]=tmp;
        }
        Rank[pu]+=Rank[pv];
        Parent[pv]=pu;
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu=new DSU(n);
        int res=n;
        for(int[] p:edges){
            if(dsu.union(p[0],p[1])){
                res--;
            }
        }
        return res;
    }
}

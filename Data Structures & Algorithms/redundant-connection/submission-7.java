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
        if(Parent[node]!=node){
            Parent[node]=find(Parent[node]);
        }
        return Parent[node];
    }
    public boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return false;
        if(Rank[pv]>Rank[pu]){
            int tmp=Rank[pu];
            Rank[pu]=Rank[pv];
            Rank[pv]=tmp;
        }
        Rank[pu]+=Rank[pv];
        Parent[pv]=pu;
        return true;
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length);
        for(int[] edge:edges){
            if(!(dsu.union(edge[0],edge[1]))) return new int[]{edge[0],edge[1]};
        }
        return new int[0];
    }
}

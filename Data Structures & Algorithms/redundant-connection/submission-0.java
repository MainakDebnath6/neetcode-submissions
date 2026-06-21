class DSU{
    int[] parent,rank;
    public DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int node){
        int cur=node;
        while(cur!=parent[cur]){
            parent[cur]=parent[parent[cur]];
            cur=parent[cur];
        }
        return cur;
    }
    public boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return false;
        if(rank[pu]<rank[pv]){
            int temp=pu;
            pu=pv;
            pv=temp;
        }
        parent[pv]=pu;
        rank[pu]+=rank[pv];
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n=edges.length+1;
        DSU dsu=new DSU(n);
        for(int[] edge:edges){
            if(!dsu.union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[0];
    }
}

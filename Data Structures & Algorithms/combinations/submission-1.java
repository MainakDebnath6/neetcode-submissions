class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        subset=new ArrayList<>();
        dfs(1,n,k);
        return ans;
    }
    private void dfs(int start,int n,int k){
        if(subset.size()==k){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int i=start;i<=n;i++){
            subset.add(i);
            dfs(i+1,n,k);
            subset.remove(subset.size()-1);
        }
    }
}
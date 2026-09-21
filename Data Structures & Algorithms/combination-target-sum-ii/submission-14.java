class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList<>();
        subset=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,candidates,target);
        return ans;
    }
    private void dfs(int i,int[] candidates, int target){
        if(i>=candidates.length && target==0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(i>=candidates.length || target<0) return;
        subset.add(candidates[i]);
        dfs(i+1,candidates,target-candidates[i]);
        subset.remove(subset.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]) i++;
        dfs(i+1,candidates,target);
    }
}

class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans=new ArrayList<>();
        subset=new ArrayList<>();
        dfs(0,nums,target);
        return ans;
    }
    private void dfs(int i,int[] nums, int target){
        if(i>=nums.length && target==0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(i>=nums.length || target<0) return;
        subset.add(nums[i]);
        dfs(i,nums,target-nums[i]);
        subset.remove(subset.size()-1);
        dfs(i+1,nums,target);
    }
}

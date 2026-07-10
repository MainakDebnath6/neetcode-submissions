class Solution {
    List<List<Integer>> res;
    List<Integer> curr; 
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        curr=new ArrayList<>();
        dfs(nums,target,0,res,curr);
        return res;
    }
    private void dfs(int[] nums, int target,int i,List<List<Integer>> res,List<Integer> curr){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        curr.add(nums[i]);
        dfs(nums,target-nums[i],i,res,curr);
        curr.remove(curr.size()-1);
        dfs(nums,target,i+1,res,curr);
    }
}

class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        subset=new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,nums);
        return ans;
    }
    private void dfs(int index,int[] nums){
        if(index>=nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index+1,nums);
        subset.remove(subset.size()-1);
        while(index+1<nums.length && nums[index]==nums[index+1]) index++;
        dfs(index+1,nums);
    }
}

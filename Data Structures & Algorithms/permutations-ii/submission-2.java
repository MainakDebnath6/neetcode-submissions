class Solution {
    List<List<Integer>> ans;
    boolean[] check;
    List<Integer> perm;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans=new ArrayList<>();
        perm=new ArrayList<>();
        check=new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return ans;
    }
    private void dfs(int[] nums){
        if(perm.size()==nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(check[i] || i>0 && nums[i]==nums[i-1] && !check[i-1]) continue;
            check[i]=true;
            perm.add(nums[i]);
            dfs(nums);
            perm.remove(perm.size()-1);
            check[i]=false;
        }
    }
}
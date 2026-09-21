class Solution {
    List<List<Integer>> res;
    List<Integer> perm;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        perm=new ArrayList<>();
        check=new boolean[nums.length];
        dfs(0,nums);
        return res;
    }
    private void dfs(int index,int[] nums){
        if(index>=nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!check[i]){
                perm.add(nums[i]);
                check[i]=true;
                dfs(index+1,nums);
                perm.remove(perm.size()-1);
                check[i]=false;
            }
        }
    }
}

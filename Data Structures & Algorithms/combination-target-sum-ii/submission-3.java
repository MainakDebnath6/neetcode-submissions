class Solution {
    List<List<Integer>> res;
    List<Integer> curr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        curr=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,res,curr,0);
        return res;
    }
    private void dfs(int[] candidates, int target,int i,List<List<Integer>> res,List<Integer> curr,int total){
        if(total==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(total>target || i==candidates.length){
            return;
        }
        curr.add(candidates[i]);
        dfs(candidates,target,i+1,res,curr,total+candidates[i]);
        curr.remove(curr.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(candidates,target,i+1,res,curr,total);
    }
}

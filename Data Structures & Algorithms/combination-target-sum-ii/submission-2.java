class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        backtrack(candidates,target,0,res,cur,0);
        return res;
    }
    private void backtrack(int[] candidates, int target,int i,List<List<Integer>> res,List<Integer> cur,int total){
        if(total==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(total>target || i>=candidates.length){
            return;
        }
        cur.add(candidates[i]);
        backtrack(candidates,target,i+1,res,cur,total+candidates[i]);
        cur.remove(cur.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        backtrack(candidates,target,i+1,res,cur,total);
    }
}

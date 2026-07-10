class Solution {
    List<List<Integer>> res;
    List<Integer> perm;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        perm=new ArrayList<>();
        boolean[] pick=new boolean[nums.length];
        backtrack(nums,res,perm,pick);
        return res;
    }
    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> perm,boolean[] pick){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
            for(int i=0;i<nums.length;i++){
                if(!pick[i]){
                    perm.add(nums[i]);
                    pick[i]=true;
                    backtrack(nums,res,perm,pick);
                    perm.remove(perm.size()-1);
                    pick[i]=false;
                }
            }
        }
    }


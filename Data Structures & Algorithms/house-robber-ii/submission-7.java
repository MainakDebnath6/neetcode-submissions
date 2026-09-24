class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(solve(nums,0,n-1),solve(nums,1,n));
    }
    private int solve(int[] nums,int l,int r){
        int rob1=0,rob2=0;
        for(int i=l;i<r;i++){
            int tmp=Math.max(nums[i]+rob1,rob2);
            rob1=rob2;
            rob2=tmp;
        }
        return rob2;
    }
}

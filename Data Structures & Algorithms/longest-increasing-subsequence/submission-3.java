class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if (n == 0) return 0;
        int[] LIS=new int[n];
        Arrays.fill(LIS,1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    LIS[i]=Math.max(LIS[i],LIS[j]+1);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(mpp.containsKey(need)){
                return new int[]{mpp.get(need),i};
            }
            mpp.put(nums[i],i);
        }
        return new int[0];
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> track=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int diff=target-num;
            if(track.containsKey(diff)){
                return new int[]{track.get(diff),i};
            }
            track.put(num,i);
        }
        return new int[] {};
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int length=0;
        for(int num:nums){
            if(!numSet.contains(num-1)){
                int longest=1;
                while(numSet.contains(num+longest)){
                    longest++;
                }
                length=Math.max(length,longest);
            }
        }
        return length;
    }
}

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int missing=1;
        sort(nums.begin(),nums.end());
        for(int num:nums){
            if(num==missing){
                missing++;
            }
        }
        return missing;
    }
};
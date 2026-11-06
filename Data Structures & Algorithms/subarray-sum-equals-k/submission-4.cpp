class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int res=0,currSum=0;
        unordered_map<int,int> mp;
        mp[0]=1;
        for(int num:nums){
            currSum+=num;
            int remaining=currSum-k;
            res+=mp[remaining];
            mp[currSum]++;
        }
        return res;
    }
};
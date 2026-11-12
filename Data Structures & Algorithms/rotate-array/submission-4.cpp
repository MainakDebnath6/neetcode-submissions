class Solution {
private:
    void shift(vector<int>& nums,int l,int r){
        while(l<r){
            int tmp=nums[l];
            nums[l]=nums[r];
            nums[r]=tmp;
            l++;
            r--;
        }
    }
public:
    void rotate(vector<int>& nums, int k) {
        int n=nums.size();
        k=k%n;
        shift(nums,0,n-1);
        shift(nums,0,k-1);
        shift(nums,k,n-1);
    }
};
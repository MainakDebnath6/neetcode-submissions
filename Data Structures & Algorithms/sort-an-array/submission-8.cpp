class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums,0,nums.size()-1);
        return nums;
    }
private:
    void mergeSort(vector<int>& arr,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,r,mid);
    }
    void merge(vector<int>& nums,int l,int r,int m){
        vector<int> tmp;
        int i=l,j=m+1;
        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                tmp.push_back(nums[i++]);
            }else{
                tmp.push_back(nums[j++]);
            }
        }
        while(i<=m){
            tmp.push_back(nums[i++]);
        }
        while(j<=r){
            tmp.push_back(nums[j++]);
        }
        for(int i=l;i<=r;i++){
            nums[i]=tmp[i-l];
        }
    }
};
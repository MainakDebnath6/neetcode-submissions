class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        quickSort(nums,0,nums.size()-1);
        return nums;
    }
private:
    void quickSort(vector<int>& arr,int l,int r){
        if(l>=r) return;
        int pi=partition(arr,l,r);
        quickSort(arr,l,pi-1);
        quickSort(arr,pi+1,r);
    }
    int partition(vector<int>& arr,int l,int r){
        int pivot=arr[r];
        int i=l;
        for(int j=i;j<r;j++){
            if(arr[j]<=pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }
    void swap(vector<int>& arr,int l,int r){
        int tmp=arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }
};
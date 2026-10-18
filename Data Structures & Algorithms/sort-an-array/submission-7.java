class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }
    private void quickSort(int[] nums,int l,int r){
        if(l>=r) return;
        int pi=partition(nums,l,r);
        quickSort(nums,l,pi-1);
        quickSort(nums,pi+1,r);
    }
    private int partition(int[] nums,int l,int r){
        int pivot=nums[r];
        int i=l;
        for(int j=i;j<r;j++){
            if(nums[j]<=pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,r);
        return i;
    }
    private void swap(int[] nums,int l,int r){
        int tmp=nums[l];
        nums[l]=nums[r];
        nums[r]=tmp;
    }
}
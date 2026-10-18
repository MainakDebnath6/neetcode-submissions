class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }
    private void mergeSort(int[] nums,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    private void merge(int[] nums,int l,int mid,int r){
        List<Integer> tmp=new ArrayList<>();
        int i=l;
        int j=mid+1;
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]){
                tmp.add(nums[i++]);
            }else{
                tmp.add(nums[j++]);
            }
        }
        while(i<=mid){
            tmp.add(nums[i++]);
        }
        while(j<=r){
            tmp.add(nums[j++]);
        }
        for(i=l;i<=r;i++){
            nums[i]=tmp.get(i-l);
        }
    }
}
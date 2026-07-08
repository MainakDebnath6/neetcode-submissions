class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Arrays.stream(piles).max().getAsInt();
        int res=0;
        while(l<=r){
            int mid=(r+l)/2;
            int sum=0;
            for(int p:piles){
                sum+=Math.ceil((double)p/mid);
            }
            if(sum<=h){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}

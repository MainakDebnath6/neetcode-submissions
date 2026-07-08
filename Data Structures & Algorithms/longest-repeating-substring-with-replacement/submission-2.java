class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mpp=new HashMap<>();
        int res=0;
        int l=0;
        int maxf=0;
        for(int r=0;r<s.length();r++){
            mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,mpp.get(s.charAt(r)));
            while((r-l+1)-maxf>k){
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
}
}

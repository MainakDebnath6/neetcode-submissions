class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int res=0;
        Set<Character> st=new HashSet<>();
        while(r<s.length()){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            r++;
            res=Math.max(res,r-l);
        }
        return res;
    }
}

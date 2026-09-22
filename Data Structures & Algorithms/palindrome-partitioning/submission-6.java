class Solution {
    List<List<String>> ans;
    List<String> subset;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        subset=new ArrayList<>();
        dfs(0,s);
        return ans;
    }
    private void dfs(int i,String s){
        if(i>=s.length()){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int k=i;k<s.length();k++){
            if(check(s,i,k)){
                subset.add(s.substring(i,k+1));
                dfs(k+1,s);
                subset.remove(subset.size()-1);
            }
        }
    }
    private boolean check(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

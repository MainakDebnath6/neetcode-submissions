class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> part=new ArrayList<>();
        dfs(s,0,res,part);
        return res;
    }
    private void dfs(String s,int i,List<List<String>> res,List<String> part){
        if(i>=s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)){
                part.add(s.substring(i,j+1));
                dfs(s,j+1,res,part);
                part.remove(part.size()-1);
            }
        }
    }
    private boolean isPali(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

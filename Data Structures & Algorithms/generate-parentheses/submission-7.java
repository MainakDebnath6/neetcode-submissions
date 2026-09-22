class Solution {
    List<String> res;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        sb=new StringBuilder();
        dfs(0,0,n);
        return res;
    }
    private void dfs(int openN,int closeN,int n){
        if(openN==n && closeN==openN){
            res.add(sb.toString());
            return;
        }
        if(openN<n){
            sb.append('(');
            dfs(openN+1,closeN,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closeN<openN){
            sb.append(')');
            dfs(openN,closeN+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

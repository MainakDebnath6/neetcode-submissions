class Solution {
    List<String> ans;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        sb=new StringBuilder();
        String[] numbers={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()<1) return ans;
        dfs(0,digits,numbers);
        return ans;
    }
    private void dfs(int i,String digits,String[] numbers){
        if(i>=digits.length()){
            ans.add(sb.toString());
            return;
        }
        String chars=numbers[digits.charAt(i)-'0'];
        for(char c:chars.toCharArray()){
            sb.append(c);
            dfs(i+1,digits,numbers);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

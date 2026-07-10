class Solution {
    List<String> res;
    String[] numbers={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        if(digits.isEmpty()) return res;
        dfs(0,"",digits);
        return res;
    }
    private void dfs(int i,String curStr,String digits){
        if(curStr.length()==digits.length()){
            res.add(curStr);
            return;
        }
        String chars=numbers[digits.charAt(i)-'0'];
        for(char c:chars.toCharArray()){
            dfs(i+1,curStr+c,digits);
        }
    }
}

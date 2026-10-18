class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String s:strs){
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}

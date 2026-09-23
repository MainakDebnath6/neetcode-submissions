class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> wordSet=new HashSet<>(wordList);
        Map<String,Integer> fromBegin=new HashMap<>(),fromEnd=new HashMap<>();
        Queue<String> qb=new LinkedList<>(),qe=new LinkedList<>();
        int m=endWord.length();
        qb.offer(beginWord);
        qe.offer(endWord);
        fromBegin.put(beginWord,1);
        fromEnd.put(endWord,1);
        while(!qb.isEmpty() && !qe.isEmpty()){
            if(qb.size()>qe.size()){
                Queue<String> tmp1=qb;
                qb=qe;
                qe=tmp1;
                Map<String,Integer> tmp2=fromBegin;
                fromBegin=fromEnd;
                fromEnd=tmp2;
            }
            String word=qb.poll();
            int steps=fromBegin.get(word);
            for(int i=0;i<m;i++){
                for(char c='a';c<='z';c++){
                    if(c==word.charAt(i)) continue;
                    String nei=word.substring(0,i)+c+word.substring(i+1);
                    if(!wordSet.contains(nei)) continue;
                    if(fromEnd.containsKey(nei)) return steps+fromEnd.get(nei);
                    if(fromBegin.containsKey(nei)) continue;
                    fromBegin.put(nei,steps+1);
                    qb.offer(nei);
                }
            }
        }
        return 0;
    }
}

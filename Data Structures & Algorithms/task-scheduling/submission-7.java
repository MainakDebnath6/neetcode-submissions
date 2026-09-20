class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        int maxf=0,maxn=0;
        int time=0;
        for(char t:tasks){
            count[t-'A']++;
            maxf=Math.max(maxf,count[t-'A']);
        }
        for(int i=0;i<26;i++){
            if(count[i]==maxf) maxn++;
        }
        time=(maxf-1)*(n+1)+maxn;
        return Math.max(time,tasks.length);
    }
}

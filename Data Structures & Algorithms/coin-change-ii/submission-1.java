class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            int[] nextDp=new int[amount+1];
            nextDp[0]=1;
            for(int a=1;a<=amount;a++){
                nextDp[a]=dp[a];
                if(a-coins[i]>=0){
                    nextDp[a]+=nextDp[a-coins[i]];
                }
            }
            dp=nextDp;
        }
        return dp[amount];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1) return 0;
        int[] dp=new int[n];
        dp[1]=Math.max(0,prices[1]-prices[0]);
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1];
            for(int j=0;j<i;j++){
                int profit=prices[i]-prices[j];
                int prevProfit=0;
                if(j>=2){
                    prevProfit=dp[j-2];
                }
                dp[i]=Math.max(dp[i],profit+prevProfit);
            }
        }
        return dp[n-1];
    }
}

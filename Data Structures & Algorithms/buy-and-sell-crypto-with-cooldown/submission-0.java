class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if (n <= 1) return 0;
        int[] t=new int[n];
        t[0]=0;
        t[1]=Math.max(prices[1]-prices[0],0);
        if(n==0 || n==1) return 0;
        for(int i=2;i<n;i++){
            t[i] = t[i - 1];
            for(int j=0;j<i;j++){
                int profit=prices[i]-prices[j];
                int prevProfit = (j >= 2) ? t[j - 2] : 0;
                t[i]=Math.max(t[i],profit+prevProfit);
            }
        }
        return t[n-1];
    }
}

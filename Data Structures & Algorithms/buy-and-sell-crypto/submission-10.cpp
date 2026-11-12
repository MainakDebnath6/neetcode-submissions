class Solution {
public:
    int maxProfit(vector<int>& prices) {
       int maxP=0;
       int minBuy=prices[0];
       for(int i=1;i<prices.size();i++){
        minBuy=min(minBuy,prices[i]);
        maxP=max(maxP,prices[i]-minBuy);
       } 
       return maxP;
    }
};

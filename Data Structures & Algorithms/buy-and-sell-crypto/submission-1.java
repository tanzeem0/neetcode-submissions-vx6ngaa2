class Solution {
    public int maxProfit(int[] prices) {
       int l = 0, r = 1;
       int maxPrft = 0;
       while(r<prices.length)
       {
            if(prices[l] < prices[r]){
                maxPrft = Math.max(maxPrft,prices[r]-prices[l]);
            }else{
                l = r;
            }
            r++;
       }
       return maxPrft;
    }
}
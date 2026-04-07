class Solution {
    public int maxProfit(int[] prices) {
        int maxPrft = 0, minStockVal = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            minStockVal = Math.min(prices[i],minStockVal);
            maxPrft = Math.max(prices[i]-minStockVal,maxPrft);
        }
        return maxPrft;
    }
}
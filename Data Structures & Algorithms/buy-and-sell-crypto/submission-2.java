class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0,maxS = 0;
        for(int i=prices.length-1;i>=0;i--){
            maxP = Math.max(maxP,maxS - prices[i]);
            maxS = Math.max(maxS,prices[i]);
        }
        return maxP;
    }
}
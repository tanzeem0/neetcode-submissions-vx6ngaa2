class Solution {
    private int mem(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = Math.max(nums[i] + mem(nums,i+2,dp),mem(nums,i+1,dp));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans= mem(nums,0,dp);
        return ans;
    }
}
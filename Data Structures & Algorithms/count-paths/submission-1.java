class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int i=m-2;i>=0;i--){
            int[] temp = new int[n];
            temp[n-1] = dp[n-1];
            for(int j=n-2;j>=0;j--){
                temp[j] = temp[j+1] + dp[j];
            }
            dp = temp;
        }
        return dp[0];
    }
}

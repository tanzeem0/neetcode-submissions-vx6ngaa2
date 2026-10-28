class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] res = new int[nums.length];
        int pref = 1,suff = 1;
        for(int i=0;i<nums.length;i++){
            res[i] = pref*nums[i];
            pref*=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i] = i-1 < 0 ? suff : res[i-1] * suff;
            suff*= nums[i];
        }
        return res;
    }
}  
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        res[0] = 1;
        int totalMulti = nums[0];
        for(int i=1;i<size;i++){
            res[i] = totalMulti;
            totalMulti *= nums[i];
        }
        totalMulti = nums[size-1];
        for(int i=size-2;i>=0;i--){
            res[i]*=totalMulti;
            totalMulti *= nums[i];
        }
        return res;
    }
}  
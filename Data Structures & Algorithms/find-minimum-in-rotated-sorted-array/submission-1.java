class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1;
        while(s<=e){
            int m = (s+e)/2;
            if(m-1 >= 0 && nums[m] < nums[m-1])
                return nums[m];
            else if(nums[s] <= nums[m])
            {
                if(nums[s] > nums[e]){
                    s = m+1;
                }else
                    e = m-1;
            }else{
                if(nums[m] < nums[e]){
                    e = m-1;
                }else
                    s = m+1;
            }
        }
        return nums[s];
    }
}

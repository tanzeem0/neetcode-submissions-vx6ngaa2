class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                Arrays.sort(nums);
        List<List<Integer>> trip = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    trip.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    do{
                        j++;
                    }while(j<k && nums[j] == nums[j-1]);
                }else if(sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return trip;
    }
}
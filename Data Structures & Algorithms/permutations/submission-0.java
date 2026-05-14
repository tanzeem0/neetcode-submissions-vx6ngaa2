class Solution {
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void findPermuations(int[] nums,int idx,List<List<Integer>> p){
        if(idx == nums.length){
            List<Integer> currPerm = Arrays.stream(nums).boxed().toList();
            p.add(currPerm);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(idx,i,nums);
            findPermuations(nums,idx+1,p);
            swap(idx,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutationsList = new ArrayList<>();
        findPermuations(nums,0,permutationsList);
        return permutationsList;
    }
}
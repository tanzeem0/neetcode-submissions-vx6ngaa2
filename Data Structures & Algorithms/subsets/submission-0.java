class Solution {
    public void findSubsets(int[] nums,int idx,List<Integer> temp,List<List<Integer>> subList){
        if(idx == nums.length){
            subList.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        findSubsets(nums,idx+1,temp,subList);
        temp.remove(temp.size()-1);
        findSubsets(nums,idx+1,temp,subList);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subList = new ArrayList<>();
        findSubsets(nums,0,new ArrayList<>(),subList);
        return subList;
    }
}
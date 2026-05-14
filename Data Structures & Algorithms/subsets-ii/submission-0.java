class Solution {
    public void subsets(int[] nums,int idx,List<List<Integer>> s,List<Integer> list){
        if(idx == nums.length){
            s.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        subsets(nums,idx+1,s,list);
        list.remove(list.size()-1);
        while(idx+1 < nums.length && nums[idx] == nums[idx+1])
            idx++;
        subsets(nums,idx+1,s,list);
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> s = new ArrayList<>();
        subsets(nums,0,s,new ArrayList<>());
        return s;
    }
}
class Solution {
    public void findCombSum(int[] candidates,int idx,List<Integer> comb,List<List<Integer>> combList,int target,int sum){
        if(sum == target){
            combList.add(new ArrayList<>(comb));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(sum + candidates[i] <= target){
                comb.add(candidates[i]);
                findCombSum(candidates,i+1,comb,combList,target,sum+candidates[i]);
                comb.remove(comb.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combList = new ArrayList<>();
        findCombSum(candidates,0,new ArrayList<>(),combList,target,0);
        return combList;
    }
}
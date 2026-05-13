class Solution {
    public void findCombSum(int[] candidates,int idx,List<Integer> comb,List<List<Integer>> combList,int target){
        if(target == 0){
            combList.add(new ArrayList<>(comb));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(target - candidates[i] >= 0){
                comb.add(candidates[i]);
                findCombSum(candidates,i,comb,combList,target-candidates[i]);
                comb.remove(comb.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combList = new ArrayList<>();
        findCombSum(candidates,0,new ArrayList<>(),combList,target);
        return combList;
    }
}
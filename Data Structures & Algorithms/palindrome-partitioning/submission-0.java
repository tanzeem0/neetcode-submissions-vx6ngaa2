class Solution {
    public boolean isPal(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public void findPartitions(String s,List<String> partitions,List<List<String>> res,int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(partitions));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String part = s.substring(idx,i+1);
            if(isPal(part)){
                partitions.add(part);
                findPartitions(s,partitions,res,i+1);
                partitions.remove(partitions.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        findPartitions(s,new ArrayList<>(),res,0);
        return res;
    }
}
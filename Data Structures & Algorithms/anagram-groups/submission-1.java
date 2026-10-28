class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String k = s;
            char[] keyArr = k.toCharArray();
            Arrays.sort(keyArr);
            k = new String(keyArr);
            map.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(var list:map.values()){
            res.add(list);
        }
        return res;
    }
}

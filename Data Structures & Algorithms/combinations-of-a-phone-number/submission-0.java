class Solution {
    public void dfs(String digits,int idx,StringBuilder sb,HashMap<Integer,String> map,List<String>res){
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(idx)-'0');
        for(char c:s.toCharArray()){
            sb.append(c);
            dfs(digits,idx+1,sb,map,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits,0,new StringBuilder(),map,res);
        return res;
    }
}
class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            res.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0,j=0;
        while(j<str.length()){
            StringBuilder curr = new StringBuilder();
            while(str.charAt(j)!='#'){
                curr.append(str.charAt(j));
                j++;
            }
            int lenOfStr = Integer.parseInt(curr.toString());
            i = j+1;
            j = i+lenOfStr;
            res.add(str.substring(i,j));
        }
        return res;
    }
}

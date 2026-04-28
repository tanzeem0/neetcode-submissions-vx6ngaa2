class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j<str.length()){
            StringBuilder len = new StringBuilder("");
            while(str.charAt(j)!='#'){
                len.append(str.charAt(j));
                j++;
            }
            int length = Integer.parseInt(len.toString());
            i = j+1;
            j = i+length;
            strs.add(str.substring(i,j));
        }
        return strs;
    }
}

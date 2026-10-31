class Solution {

    public String encode(List<String> strs) {
        String enc = "";
        for(String s:strs){
            enc += s.length()+ "-" + s;
        }
        System.out.println(enc);
        return enc;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int sepInd = str.indexOf('-',i);
            System.out.println(sepInd);
            int len = Integer.valueOf(str.substring(i,sepInd));
            i = sepInd+1;
            res.add(str.substring(i,i+len));
            i = i+len;
        }
        return res;
    }
}

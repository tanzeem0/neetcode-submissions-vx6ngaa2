class Solution {
    public void genParen(int n,int o,int c,StringBuilder sb,List<String> res){
        if(o == n && c == n){
            res.add(sb.toString());
            return;
        }
        if(o < n){
            sb.append('(');
            o++;
            genParen(n,o,c,sb,res);
            o--;
            sb.deleteCharAt(sb.length()-1);
        }if(c < o){
            sb.append(')');
            c++;
            genParen(n,o,c,sb,res);
            c--;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParen(n,0,0,new StringBuilder(),res);
        return res;
    }
}
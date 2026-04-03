class Solution {
    public boolean isAlphaNum(char c){
        if((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        while(start<end){
            if(isAlphaNum(s.charAt(start)) && isAlphaNum(s.charAt(end))){
                if(s.charAt(start)!=s.charAt(end))
                    return false;
                start++;
                end--;
            }else if(isAlphaNum(s.charAt(start))){
                end--;
            }else
                start++;
        }
        return true;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uset = new HashSet<>();
        int i = 0, j = 0,longSub = 0;
        while(j<s.length()){
            if(!uset.add(s.charAt(j))){
                uset.remove(s.charAt(i++));
            }else{
                longSub = Math.max(longSub,uset.size());
                j++;
            }
        }
        return longSub;
    }
}
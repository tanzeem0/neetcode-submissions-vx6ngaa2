class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        int lenOfLongest = 0;
        int l = 0, r = 0;
        while(r<s.length())
        {
            while(hash.contains(s.charAt(r))){
                hash.remove(s.charAt(l));
                l++;
            }
            hash.add(s.charAt(r));
            r++;
            lenOfLongest = Math.max(lenOfLongest,hash.size());
        }
        return lenOfLongest;
    }
}
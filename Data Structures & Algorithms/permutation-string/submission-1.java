class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i=0;i<s1.length();i++){
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(s1Map[i] == s2Map[i])
                count++;
        }
        int l = 0;
        for(int r=s1.length();r<s2.length();r++){
            if(count == 26)
                return true;
            s2Map[s2.charAt(r)-'a']++;
            if(s2Map[s2.charAt(r)-'a'] == s1Map[s2.charAt(r)-'a'])
                count++;
            else if(s1Map[s2.charAt(r)-'a'] + 1 == s2Map[s2.charAt(r)-'a'])
                count--;
            s2Map[s2.charAt(l)-'a']--;
            if(s2Map[s2.charAt(l)-'a'] == s1Map[s2.charAt(l)-'a'])
                count++;
            else if(s1Map[s2.charAt(l)-'a'] - 1 == s2Map[s2.charAt(l)-'a'])
                count--;
            l++;
        }

        return count == 26 ? true : false;
    }
}

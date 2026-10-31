class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> m = new HashMap<>();
        for(char c:s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            if(m.containsKey(c)){
                m.put(c,m.get(c)-1);
                if(m.get(c) == 0)
                    m.remove(c);
            }else
                return false;
        }
        return m.isEmpty();
    }
}
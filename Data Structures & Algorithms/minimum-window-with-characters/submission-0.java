class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character,Integer> tMap = new HashMap<>();
       HashMap<Character,Integer> windowMap = new HashMap<>();

       for(char c:t.toCharArray()){
        tMap.put(c,tMap.getOrDefault(c,0)+1);
       }
       int minLen = Integer.MAX_VALUE, minLeft = 0, l = 0, r = 0;
       int have = 0, need = tMap.size();
       while(r<s.length())
       {
            char c = s.charAt(r);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);

            if(tMap.containsKey(c) && windowMap.get(c).equals(tMap.get(c))){
                have++;
            }
            while(have == need)
            {
                if(minLen > r-l+1){
                    minLen = r-l+1;
                    minLeft = l;
                }
                char c2 = s.charAt(l);
                windowMap.put(c2,windowMap.getOrDefault(c2,0)-1);
                if(tMap.containsKey(c2) && windowMap.get(c2) < tMap.get(c2))
                    have--;
                l++;
            }
            r++;
       }
       return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft,minLeft+minLen);
    }
}
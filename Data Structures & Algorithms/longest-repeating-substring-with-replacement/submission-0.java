class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int start = 0, end = 0,highFreq = 0,longestSub = 0;
        char hch = s.charAt(0);
        while(end<s.length()){
            freqMap.put(s.charAt(end),freqMap.getOrDefault(s.charAt(end),0)+1);
            if(highFreq < freqMap.get(s.charAt(end)))
            {
                highFreq = freqMap.get(s.charAt(end));
                hch = s.charAt(end);
            }
            while(end-start+1 - highFreq > k){
                freqMap.put(s.charAt(start),freqMap.get(s.charAt(start))-1);
                if(freqMap.get(s.charAt(start)) == 0)
                    freqMap.remove(s.charAt(start));
                start++;
            }
            longestSub = Math.max(longestSub,end-start+1);
            end++;
        }
        return longestSub;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int num:nums)
            hash.add(num);
        
        int longConsLen = 0;
        for(int num:hash){
            if(!hash.contains(num-1)){
                int currConsLen = 0;
                int number = num;
                while(hash.contains(number)){
                    currConsLen++;
                    number++;
                }
                longConsLen = Math.max(longConsLen,currConsLen);
            }
        }
        return longConsLen;
    }
}
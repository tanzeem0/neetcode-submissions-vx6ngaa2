class Solution {
    public int maxArea(int[] height) {
        // most amount of water we can contain inside this container
        // rectangle area -- len x breadth 
        // Formula - (j-i)xMin(height[j],height[i])
        // observations
        /*
            Trying to find the max containing water from the farthest makes sense
            start with farthest then reduce the pointers to capture the most heightest
            peaks
         */
         int left = 0, right = height.length-1;
         int mostContWater = 0;
         while(left<right){
            int currContWater = (right-left)*Math.min(height[left],height[right]);
            mostContWater = Math.max(currContWater,mostContWater);
            if(height[left]<=height[right]){
                left++;
            }else
                right--;
         }
         return mostContWater;
    }
}
class Solution {
    public int trap(int[] height) {
      int n = height.length;
        int maxL = 0, maxR = 0,l=0,r=n-1, trapWater = 0;
        while(l<r){
            maxL = Math.max(maxL,height[l]);
            maxR = Math.max(maxR,height[r]);
            if(maxL < maxR){
                trapWater += (maxL - height[l]);
                l++;
            }else{
                trapWater += (maxR - height[r]);
                r--;
            }
        }
        return trapWater;
    }
}
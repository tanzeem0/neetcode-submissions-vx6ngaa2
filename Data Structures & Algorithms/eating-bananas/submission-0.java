class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 0;
        int l = 1, r = 0;
        for(int p:piles)
            r = Math.max(r,p);
        while(l<r)
        {
            int m = l + (r-l)/2;
            int currTime = 0;
            for(int p:piles){
                currTime += p/m;
                if(p%m != 0)
                    currTime+=1;
            }
            if(currTime <= h){
                r = m;
            }
            else
                l = m+1;
        }
        speed = l;
        return speed;
    }
}
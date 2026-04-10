class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0;i<k;i++)
            maxH.offer(new int[]{nums[i],i});
        
        int l = 0;
        for(int r=k;r<nums.length;r++)
        {
            res.add(maxH.peek()[0]);
            l++;
            while(!maxH.isEmpty() && maxH.peek()[1] < l)
                maxH.poll();
            maxH.offer(new int[]{nums[r],r});
        }
        res.add(maxH.peek()[0]);
        int[] arr = new int[res.size()];
        for(int i=0;i<res.size();i++)
            arr[i] = res.get(i);
        return arr;
    }
}
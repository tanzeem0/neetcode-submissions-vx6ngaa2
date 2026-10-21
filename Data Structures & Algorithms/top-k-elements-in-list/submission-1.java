class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int n:nums)
            m.put(n,m.getOrDefault(n,0)+1);
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2)-> p1.getValue()-p2.getValue());
        for(var e:m.entrySet()){
            minHeap.offer(new Pair<>(e.getKey(),e.getValue()));
            if(minHeap.size()>k)
                minHeap.poll();
        }
        int[] res = new int[minHeap.size()];
        for(int i=0;i<res.length;i++){
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
}
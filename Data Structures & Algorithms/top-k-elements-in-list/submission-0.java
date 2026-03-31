class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            priorityQueue.offer(new int[]{entry.getValue(), entry.getKey()});
            if(priorityQueue.size() > k)
                priorityQueue.poll();
        }
        int i = 0;
        int[] res = new int[k];
        while(!priorityQueue.isEmpty()){
            res[i] = priorityQueue.poll()[1];
            i++;
        }
        return res;
    }
}

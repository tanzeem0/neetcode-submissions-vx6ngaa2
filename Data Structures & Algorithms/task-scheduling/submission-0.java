class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer,Integer> ts = new HashMap<>();
        int[] hash = new int[26];
        for(char c:tasks){
            hash[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> hash[b]-hash[a]);
        for(int i=0;i<26;i++){
            if(hash[i] > 0)
                pq.offer(i);
        }
        int time = 0;
        while(!pq.isEmpty())
        {
            time++;
            Queue<Integer> q = new LinkedList<>();
            while(ts.containsKey(pq.peek()) && ts.get(pq.peek()) + n >= time){
                q.offer(pq.poll());
            }
            if(!pq.isEmpty()){
                int top = pq.poll();
                hash[top]-=1;
                if(hash[top] > 0)
                    pq.offer(top);
                ts.put(top,time);
            }
            while(!q.isEmpty()){
                pq.offer(q.poll());
            }
        }
        return time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Prims Algo
        int time = 0;
        List<List<int[]>> adj = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            int u = t[0], v = t[1], wt = t[2];
            adj.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty() && vis.size() < n){
            int[] node = pq.poll();
            int v = node[0], wt = node[1];
            if(vis.contains(v)) continue;
            vis.add(v);
            time = wt;
            for(int[] t:adj.get(v)){
                if(!vis.contains(t[0])){
                    pq.offer(new int[]{t[0],t[1] + wt});
                }
            }
        }
        
        return (time == 0 || vis.size() < n) ? -1 : time;
    }
}
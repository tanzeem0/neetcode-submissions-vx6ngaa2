class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Prims Algorithm for MST
        // [u,v,wt]
        int minCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        Set<List<Integer>> vis = new HashSet<>(); 
        pq.offer(new int[]{points[0][0],points[0][1],0});
        while(!pq.isEmpty() && vis.size() < points.length){ // E*ElogE -- E^2LogE
            int[] point = pq.poll(); // LogE
            int u = point[0], v = point[1], dis = point[2];
            if(vis.contains(List.of(u,v))) continue;
            minCost+=dis;
            vis.add(List.of(u,v));
            for(int[] p:points){ // 10^6 or E*E
                if(p[0] == u && p[1] == v) continue;
                if(!vis.contains(List.of(p[0],p[1]))){
                    pq.offer(new int[]{p[0],p[1],(Math.abs(u-p[0])+Math.abs(v-p[1]))});
                }
            }
        }
        return vis.size() == points.length ? minCost : -1;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DAG -- > Kah'n Algo
        int[] in = new int[numCourses];
        int cnt = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int u = p[0];
            int v = p[1];
            adj.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int fr = q.poll();
            cnt++;
            for(int v:adj.get(fr)){
                in[v]--;
                if(in[v] == 0)
                    q.offer(v);
            }
        }
        return cnt == numCourses;
    }
}
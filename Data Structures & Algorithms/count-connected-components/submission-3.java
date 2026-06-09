class Solution {
    public void dfs(int node,List<List<Integer>> adj,int[] vis){
        if(vis[node]!= 0)
            return;
        vis[node] = 1;
        for(int e:adj.get(node)){
            dfs(e,adj,vis);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int connectedComp = 0;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis);
                connectedComp++;
            }
        }
        return connectedComp;
    }
}

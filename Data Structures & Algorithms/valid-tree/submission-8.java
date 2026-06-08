class Solution {
    public boolean dfs(List<List<Integer>> adj,Set<Integer> vis,int par,int node){
        if(vis.contains(node)) return false;
        vis.add(node);
        for(int v:adj.get(node)){
            if(v == par) continue;
            if(!dfs(adj,vis,node,v))
                return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        // Tree
        // 1. all nodes connected
        // 2. No loops
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        boolean res = dfs(adj,vis,-1,0);
        return vis.size() == n && res;
        
    }
}

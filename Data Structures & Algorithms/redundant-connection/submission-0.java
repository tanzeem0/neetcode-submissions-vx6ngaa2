class Solution {
    int[] parent;
    private int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    private void union(int x,int y){
        parent[x] = y;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i=0;i<n;i++)
            parent[i] = i;
        
        for(int[] e:edges){
            int px = find(e[0]);
            int py = find(e[1]);
            if(px == py){
                return e;
            }else{
                union(px,py);
            }
        }
        return new int[0];

    }
}
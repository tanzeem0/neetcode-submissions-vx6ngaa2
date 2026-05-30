/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node,HashMap<Integer,Node> vis,HashMap<Integer,List<Integer>> adj)
    {
        if(vis.containsKey(node.val)) return;
        vis.put(node.val,new Node(node.val));
        adj.putIfAbsent(node.val,new ArrayList<>());
        for(Node n:node.neighbors){
            adj.get(node.val).add(n.val);
            dfs(n,vis,adj);
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        HashMap<Integer,Node> m = new HashMap<>();
        dfs(node,m,adj);
        for(var entry:adj.entrySet()){
            for(int num:entry.getValue()){
                m.get(entry.getKey()).neighbors.add(m.get(num));
            }
        }
        return m.get(node.val);
    }
}
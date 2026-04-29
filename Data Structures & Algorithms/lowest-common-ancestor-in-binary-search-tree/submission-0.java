/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode l = null,r = null;
        if(p.val < root.val){
            l = lca(root.left,p,q);
        }if(q.val > root.val){
            r = lca(root.right,p,q);
        }
        if(l != null && r != null) return root;
        return l != null ? l : r;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < q.val ? lca(root,p,q) : lca(root,q,p);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int countGoodNodes = 0;
    public void dfs(TreeNode root,int maxi){
        if(root == null) return;
        if(root.val >= maxi)
            countGoodNodes++;
        dfs(root.left,Math.max(maxi,root.val));
        dfs(root.right,Math.max(maxi,root.val));
    }
    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        return countGoodNodes;
    }
}

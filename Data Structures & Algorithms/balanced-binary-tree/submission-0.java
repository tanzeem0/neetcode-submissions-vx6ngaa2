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
    boolean isBalance = true;
    public int isBalTree(TreeNode root){
        if(root == null) return 0;
        int l = isBalTree(root.left);
        int r = isBalTree(root.right);
        if(isBalance && Math.abs(l-r) > 1) 
            isBalance = false;
        return 1 + Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        isBalTree(root);
        return isBalance;
    }
}

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
    int diameter = 0;
    public int calDiameter(TreeNode root){
        if(root == null) return 0;
        int leftH = calDiameter(root.left);
        int rightH = calDiameter(root.right);
        diameter = Math.max(leftH+rightH,diameter);
        return 1 + Math.max(leftH,rightH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        calDiameter(root);
        return diameter;
    }
}

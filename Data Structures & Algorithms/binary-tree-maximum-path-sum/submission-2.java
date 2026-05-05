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
    public int maxSum(TreeNode root,int[] maxi){
        if(root == null) return 0;
        int l = Math.max(maxSum(root.left,maxi),0);
        int r = Math.max(maxSum(root.right,maxi),0);
        maxi[0] = Math.max(maxi[0],root.val+l+r);
        return root.val + Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxSum(root,maxi);
        return maxi[0];
    }
}

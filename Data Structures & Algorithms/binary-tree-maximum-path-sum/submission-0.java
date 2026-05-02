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
    public int maxPathSum(TreeNode root) {
        // Initialize with a very small number to handle trees with all negative values
        int[] max = {Integer.MIN_VALUE};
        gainFromSubtree(root, max);
        return max[0];
    }

    private int gainFromSubtree(TreeNode root, int[] max) {
        if (root == null) return 0;

        // Step 1: Recursively find the max gain from left and right subtrees
        // If the gain is negative, we treat it as 0 (don't include that branch)
        int leftGain = Math.max(gainFromSubtree(root.left, max), 0);
        int rightGain = Math.max(gainFromSubtree(root.right, max), 0);

        // Step 2: Check if the path through the current node (acting as the peak) 
        // is better than the current global maximum.
        int currentPathSum = root.val + leftGain + rightGain;
        max[0] = Math.max(max[0], currentPathSum);

        // Step 3: Return the max contribution this node can give to its parent.
        // A parent can only pick ONE branch (left or right) to continue the path.
        return root.val + Math.max(leftGain, rightGain);
    }
}

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> level = new ArrayList<>();
        if(root == null) return level;
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> eachLevel = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode node = q.poll();
                eachLevel.add(node.val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            level.add(eachLevel);
        }
        return level;
    }
}
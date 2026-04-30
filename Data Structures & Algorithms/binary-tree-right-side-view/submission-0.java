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
    public void rsv(TreeNode root,int depth,List<Integer> rightSideList){
        if(root == null) return;
        if(rightSideList.size() == depth)
            rightSideList.add(root.val);
        rsv(root.right,depth+1,rightSideList);
        rsv(root.left,depth+1,rightSideList);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideList = new ArrayList<>();
        rsv(root,0,rightSideList);
        return rightSideList;
    }
}

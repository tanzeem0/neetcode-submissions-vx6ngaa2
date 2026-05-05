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

public class Codec {

    // Encodes a tree to a single string.
    public void dfsSerializer(TreeNode root, List<String> preorder){
        if(root == null){
            preorder.add("N");
            return;
        }
        preorder.add("" + root.val);
        dfsSerializer(root.left,preorder);
        dfsSerializer(root.right,preorder);
    }
    public String serialize(TreeNode root) {
        List<String> preorder = new ArrayList<>();
        dfsSerializer(root,preorder);
        String data = String.join(",",preorder);
        return data;
    }
    public TreeNode dfsDeserializer(String[] pre,int[] preInd){
        if(preInd[0] == pre.length) return null;
        if(pre[preInd[0]].equals("N"))
        {
            preInd[0] +=1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(pre[preInd[0]]));
        preInd[0] +=1;
        node.left = dfsDeserializer(pre,preInd);
        node.right = dfsDeserializer(pre,preInd);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = data.split(",");
        return dfsDeserializer(pre,new int[1]);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
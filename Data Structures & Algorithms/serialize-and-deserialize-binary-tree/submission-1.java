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
    public String serialize(TreeNode root) {
        if(root==null) return "N";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null) res.append("N,");
            else{
                res.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals=data.split(",");
        if(vals[0]=="N") return null;
        TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int index=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(!vals[index].equals("N")){
                node.left=new TreeNode(Integer.parseInt(vals[index]));
                q.add(node.left);
            }
            index++;
            if(!vals[index].equals("N")){
                node.right=new TreeNode(Integer.parseInt(vals[index]));
                q.add(node.right);
            }
            index++;
        }
        return root;
    }
}

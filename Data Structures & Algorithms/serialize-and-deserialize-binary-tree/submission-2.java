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
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("N,");
            }else{
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s=data.split(",");
        if(s[0]=="N") return null;
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        q.offer(root);
        int index=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(!s[index].equals("N")){
                node.left=new TreeNode(Integer.parseInt(s[index]));
                q.add(node.left);
            }
            index++;
            if(!s[index].equals("N")){
                node.right=new TreeNode(Integer.parseInt(s[index]));
                q.add(node.right);
            }
            index++;
        }
        return root;
    }
}

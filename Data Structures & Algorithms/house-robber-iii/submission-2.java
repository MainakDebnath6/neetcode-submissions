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
    public int rob(TreeNode root) {
        int[] options=dfs(root);
        return Math.max(options[0],options[1]);
    }
    private int[] dfs(TreeNode root){
        if(root==null) return new int[2];
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] options=new int[2];
        options[0]=root.val+left[1]+right[1];
        options[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return options;
    }
}
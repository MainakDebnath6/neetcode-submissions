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
    int preIdx=0;
    Map<Integer,Integer> mp;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return dfs(preorder,0,inorder.length-1);
    }
    private TreeNode dfs(int[] preorder,int l,int r){
        if(l>r) return null;
        TreeNode node=new TreeNode(preorder[preIdx++]);
        int mid=mp.get(node.val);
        node.left=dfs(preorder,l,mid-1);
        node.right=dfs(preorder,mid+1,r);
        return node;
    }
}

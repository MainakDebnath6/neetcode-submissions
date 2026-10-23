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
        return build(0,preorder.length-1,preorder);
    }
    private TreeNode build(int l,int r,int[] preorder){
        if(l>r) return null;
        TreeNode node=new TreeNode(preorder[preIdx++]);
        int mid=mp.get(node.val);
        node.left=build(l,mid-1,preorder);
        node.right=build(mid+1,r,preorder);
        return node;
    }
}

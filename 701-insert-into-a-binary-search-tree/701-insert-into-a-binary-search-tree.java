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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode node=root,prev=root;
        TreeNode get=new TreeNode(-1);
        while(root!=null){
            prev=root;
            if(root.val>val){
               get=root;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        // System.out.println(get.val);
         TreeNode add=new TreeNode(val);
        if(get.val!=-1){
       
        add.left=get.left;
        get.left=add;
        }else{
            prev.right=add;
        }
        
        return node;
    }
}
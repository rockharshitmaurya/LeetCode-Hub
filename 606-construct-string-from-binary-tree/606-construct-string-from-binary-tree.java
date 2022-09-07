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
    String str="";
    public String tree2str(TreeNode root) {
        helper(root);
        return str;
    }
    
    void helper(TreeNode root){
        if(root==null){
             return ;
        } 
        str+=root.val;
        if(root.left==null && root.right==null){
            return;
        }
        str+="(";
        helper(root.left);
        str+=")";
        if(root.right!=null){
            str+="(";
            helper(root.right);
            str+=")";
        }
    }
}
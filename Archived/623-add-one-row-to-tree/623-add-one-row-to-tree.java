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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode new_root=new TreeNode(0);
        new_root.left=root;
        
        helper(root,val,depth,new_root,true,false);
        return new_root.left;
    }
    
    void helper(TreeNode root,int val,int depth,TreeNode parent,boolean left,boolean right){
        
        
        if(depth==1){
            TreeNode toadd=new TreeNode(val);
            if(left){
              toadd.left=parent.left;
              parent.left=toadd;
            } 
            else if(right) {
                toadd.right=parent.right;
                parent.right=toadd; 
            }
            return;
        }
        if(root==null) return;
        helper(root.left,val,depth-1,root,true,false);
        helper(root.right,val,depth-1,root,false,true);
        
    }
}
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
    
    public int minDepth(TreeNode root) { if(root==null) return 0;
        return helper(root,root,1)-1;
    }
    int helper(TreeNode root,TreeNode parent,int level){        
        if(root==null){
            if(parent.left==null && parent.right==null) return level;
            else return Integer.MAX_VALUE;
        }
        int left = helper(root.left,root,level+1);
        int right= helper(root.right,root,level+1);
        // System.out.println(root.val+" "+level);
        return Math.min(left,right);
    }
}
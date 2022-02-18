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
    int ans=0;
    public int goodNodes(TreeNode root) {
    
        helper(root,root.val);
        return ans;
    }
    int helper(TreeNode root,int max){
       if(root==null) return 0;
        if(root.val>=max) ans++;
        max=Math.max(max,root.val);
        return helper(root.left,max)+helper(root.right,max);
    }
}
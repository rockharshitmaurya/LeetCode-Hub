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

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean helper(TreeNode root, int min, int max) {
        if (root == null) return true;
        root.val=root.val%(int)1e9+7;
        
        // if (root.val > max || root.val < min) return false;
        if(root.val<=min || root.val>=max) return false;
        return helper(root.left, min, Math.min(max, root.val)) && helper(root.right, Math.max(min, root.val), max);
    }
}

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
    public boolean evaluateTree(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
    boolean right = evaluateTree(root.right);
        boolean ans = root.val == 3 ? left & right :left|right;
        return ans;
    }
}
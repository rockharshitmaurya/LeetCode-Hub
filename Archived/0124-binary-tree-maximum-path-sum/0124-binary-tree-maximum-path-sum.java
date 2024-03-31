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

    public int maxPathSum(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = -100000;
        helper(root, ans);
        return ans[0];
    }

    int helper(TreeNode root, int ans[]) {
        if (root == null) return 0;

        int left = helper(root.left, ans);
        int right = helper(root.right, ans);

        if (left < 0) left = 0;
        if (right < 0) right = 0;
        
        ans[0] = Math.max(left + right + root.val, ans[0]);

        return Math.max(left, right) + root.val;
    }
}

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
    int ans = 0;

    public int longestZigZag(TreeNode root) {
        System.out.println("---------------------");

        helper(root, 0, false, false);
        return ans;
    }

    int helper(TreeNode root, int score, boolean left, boolean right) {
        if (root == null) return 0;

        // System.out.println(score);
        ans=Math.max(ans,score);


        helper(root.left, left ? 1 : score + 1, true, false);
        System.out.println(score);
        helper(root.right, right ? 1 : score + 1, false, true);

        return 0;
    }
}

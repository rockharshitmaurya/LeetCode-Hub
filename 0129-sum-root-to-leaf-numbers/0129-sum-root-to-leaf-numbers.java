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

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        int newSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return newSum;
        }

        int leftSum = sum(node.left, newSum);
        int rightSum = sum(node.right, newSum);

        return leftSum + rightSum;
    }
}

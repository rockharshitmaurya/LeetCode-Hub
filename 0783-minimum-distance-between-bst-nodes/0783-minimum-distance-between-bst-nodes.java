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
    int max = (int) 1e8, min = (int) -1e8;

    public int minDiffInBST(TreeNode root) {
        int arr[] = new int[] { max,min,max };
        helper(root, arr);
        return arr[2];
    }

    void helper(TreeNode root, int arr[]) {
        if (root == null) {
            return;
        }

        helper(root.left, arr);
        arr[2] = Math.min(arr[2], Math.min(Math.abs(arr[1] - root.val), Math.abs(arr[0] - root.val)));
        arr[0] = Math.min(arr[0], root.val);
        arr[1] = Math.max(arr[1], root.val);
        helper(root.right, arr);
    }
}

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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode toadd = new TreeNode(val);
        TreeNode temp = root, prev = temp;
        if (root.val < val) {
            toadd.left = root;
            return toadd;
        }

        while (temp != null && temp.val >= val) {
            prev = temp;
            temp = temp.right;
        }
        // System.out.println(temp == null ? "null" : temp.val);
        if (temp != null && temp.val != val) {
            toadd.left = prev.right;
            prev.right = toadd;
        } else {
            toadd.right = prev.right;
            prev.right = toadd;
        }
        return root;
    }
}

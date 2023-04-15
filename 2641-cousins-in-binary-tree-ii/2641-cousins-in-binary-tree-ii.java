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

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<TreeNode> set = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                set.add(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    sum += cur.left.val;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    sum += cur.right.val;
                }
            }
            for (TreeNode node : set) {
                int right = node.right == null ? 0 : node.right.val;
                int left = node.left == null ? 0 : node.left.val;
                if (node.left != null) {
                    node.left.val = sum - (left + right);
                }
                if (node.right != null) {
                    node.right.val = sum - (left + right);
                }
            }
        }
        root.val = 0;
        return root;
    }
}

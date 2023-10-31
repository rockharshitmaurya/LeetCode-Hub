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
    HashMap<Integer, Integer> map;

    public boolean isEvenOddTree(TreeNode root) {
        map = new HashMap<>();

        return helper(root, 0);
    }

    boolean helper(TreeNode root, int level) {
        if (root == null) return true;

        if (map.containsKey(level)) {
            if (level % 2 == 0 && root.val % 2 == 1 && root.val > map.get(level)) {
                map.put(level, root.val);
            } else if (level % 2 == 1 && root.val % 2 == 0 && root.val < map.get(level)) {
                map.put(level, root.val);
            } else {
                return false;
            }
        } else {
            if (level % 2 == 0 && root.val % 2 == 1) {
                map.put(level, root.val);
            } else if (level % 2 == 1 && root.val % 2 == 0) {
                map.put(level, root.val);
            } else {
                return false;
            }
        }

        if (!helper(root.left, level + 1)) return false;
        if (!helper(root.right, level + 1)) return false;
        return true;
    }
}

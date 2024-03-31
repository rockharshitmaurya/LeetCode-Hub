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
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        int count = 0;

        for (int num : map.values()) {
            if (num == max) count++;
        }
        int ans[] = new int[count];
        int idx = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == max) ans[idx++] = num;
        }
        return ans;
    }

    int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        map.put(left + right + root.val, map.getOrDefault(left + right + root.val, 0) + 1);
        max = Math.max(max, map.get(left + right + root.val));
        return left + right + root.val;
    }
}

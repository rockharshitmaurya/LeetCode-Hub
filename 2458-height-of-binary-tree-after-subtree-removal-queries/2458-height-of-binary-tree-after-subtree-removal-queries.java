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
    HashMap<Integer, int[]> map = new HashMap<>();
    HashMap<Integer, Queue<Integer>> level = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] q) {
        helper(root, 0);
        for (int i = 0; i < q.length; i++) {
            int node = q[i];
            int cur_level = map.get(node)[0];
            int ans = cur_level - 1;
            if (level.get(cur_level).size() != 1) {
                int max2 = level.get(cur_level).poll();
                int max1 = level.get(cur_level).poll();
                int cur_node_depth = map.get(node)[1];
                if (max1 != cur_node_depth) ans = max1; else ans = max2;

                level.get(cur_level).add(max1);
                level.get(cur_level).add(max2);
            }
            q[i] = ans;
        }
        return q;
    }

    int helper(TreeNode root, int depth) {
        if (root == null) return depth - 1;
        if (!level.containsKey(depth)) level.put(depth, new PriorityQueue<>());
        int l = helper(root.left, depth + 1);
        int r = helper(root.right, depth + 1);
        level.get(depth).add(Math.max(l, r));
        if (level.get(depth).size() > 2) level.get(depth).poll();
        map.put(root.val, new int[] { depth, Math.max(l, r) });
        return map.get(root.val)[1];
    }
}

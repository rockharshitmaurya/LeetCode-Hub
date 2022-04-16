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
    int set=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        dfs(root,0);
        return root;
    }
    void dfs(TreeNode root,int sum){
        if(root==null) return;
         dfs(root.right,(sum+root.val));
        set+=root.val;
        root.val=set;
         System.out.print(root.val+" ");
         dfs(root.left,(sum+root.val));
    }
}
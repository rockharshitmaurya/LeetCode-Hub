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
    public int averageOfSubtree(TreeNode root) {
        return helper(root)[2];
    }
    //int[]{count,sum,ans}
    int[] helper(TreeNode root){
        if(root==null) return new int[]{0,0,0};
        
        int left[]=helper(root.left);
        int right[]=helper(root.right);
        int ans[]=new int[3];
        ans[0]=1+left[0]+right[0];
        ans[1]=root.val+left[1]+right[1];
        ans[2]=left[2]+right[2]+((ans[1]/ans[0])==root.val?1:0);
        return ans;
    }
}
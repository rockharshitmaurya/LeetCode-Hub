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
    public int maxPathSum(TreeNode root) {
        int arr[]=new int[1];
        arr[0]=Integer.MIN_VALUE;
        return check(root,arr).ans;
        // return arr[0];
    }
    Pair check(TreeNode root,int[] arr){
        if(root==null)  return new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
        
        Pair lh=check(root.left,arr);
        Pair rh=check(root.right,arr);
        
        int lh_m=Math.max(0,lh.val);
        int rh_m=Math.max(0,rh.val);
        int new_val=Math.max(lh_m,rh_m)+root.val;
        int new_ans=Math.max(lh_m+rh_m+root.val,Math.max(lh.ans,rh.ans));
        
        // arr[0]=Math.max(arr[0],lh+rh+root.val);
        // return root.val+Math.max(lh,rh);
        return new Pair(new_val,new_ans);
    }
    class Pair{
        int ans;
        int val;
        Pair(int val,int ans){
            this.val=val;
            this.ans=ans;
        }
    }
}
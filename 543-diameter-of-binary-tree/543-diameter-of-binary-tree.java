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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
            Pair p=helper(root);
        return p.ans;
    }
    Pair helper(TreeNode root){
        if(root==null) return new Pair(0,0);
        Pair l=helper(root.left);
        Pair r=helper(root.right);
        
        int max_len=Math.max(l.len,r.len)+1;
        int max_ans=Math.max(l.len+r.len,Math.max(l.ans,r.ans));
        Pair new_ans=new Pair(max_len,max_ans);
        return new_ans;
    }
    class Pair{
        int len;
        int ans;
        Pair(int _len,int _ans){
            this.len=_len;
            this.ans=_ans;
        }
    }
}
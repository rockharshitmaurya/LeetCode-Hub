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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ans=new LinkedList<>();
        if(root!=null)q.offer(root);
        while(q.size()>0){
            int size=q.size();
            ans.add(q.peek().val);
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                if(node.right!=null) q.offer(node.right);
                if(node.left!=null) q.offer(node.left);
            }
        }
        return ans;
    }
}
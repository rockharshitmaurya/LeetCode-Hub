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
    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayList<ArrayList<Integer>> level=new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            level.add(temp);
        }
        q.offer(root); int cur_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                if(cur_level%2==1){
                    node.val=level.get(cur_level).get(size-i-1);
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            cur_level++;
        }
        
        return root;
    }
}
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,ans,new ArrayList<>(),targetSum);
        
        return ans;
    }
    
    void dfs(TreeNode root,List<List<Integer>> ans,List<Integer> temp,int target){
        if(root==null) return;
        
        temp.add(root.val);
        
        if(root.left==null && root.right==null && target==root.val){
            ans.add(new ArrayList<>(temp));
        }
        
        dfs(root.left,ans,temp,target-root.val);
        dfs(root.right,ans,temp,target-root.val);
        
        temp.remove(temp.size()-1);
    }
}
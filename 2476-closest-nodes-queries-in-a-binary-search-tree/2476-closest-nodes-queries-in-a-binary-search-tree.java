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
    TreeMap<Integer,Integer> map=new TreeMap<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root);
        // System.out.println(map);
        for(int num : queries){
            
            Integer low=map.floorKey(num);
            Integer high=map.ceilingKey(num);
            // System.out.println(low+" "+high);
            ans.add(List.of(low==null?-1:low,high==null?-1:high));
        }
        return ans;
    }
    
    void helper(TreeNode root){
        if(root==null) return ;
        
        map.put(root.val,0);
        helper(root.left);
        helper(root.right);
    }
}
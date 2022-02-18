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
class FindElements {
       Set<Integer> seen = new HashSet<>();
    
    public FindElements(TreeNode root) {
    helper(root,0);   
    }
    
    public boolean find(int target) {
      return seen.contains(target);
    }
    void helper(TreeNode root,int val){
       if(root==null) return;
        seen.add(val);
        helper(root.left,2*val+1);
        helper(root.right,2*val+2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return root;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        if(root.val<low || root.val>high){
            root= helper(root,low,high);
        }
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            if(node.left!=null){
                if(node.left.val<low || node.left.val>high){
                    node.left=helper(node.left,low,high);
                }
            }
            // else{
                if(node.left!=null) st.push(node.left);
            // }
            if(node.right!=null){
                if(node.right.val<low || node.right.val>high){
                node.right=helper(node.right,low,high);
                }
            }
            // else{
                if(node.right!=null) st.push(node.right);
            // }
            
        }
        return root;

    }
    
    TreeNode helper(TreeNode root,int low,int high){
            while(root!=null){
                if(root.val>high){
                    root=root.left;
                }else if(root.val<low){
                    root=root.right;
                }else{
                    return root;
                }
                
            } 
        return root;
        // if(root.val< low){
          //     while(root!=null && root.val<low){
          //         root=root.right;
          //     }
          //     return root;
          // }else{
          //   while(root!=null && root.val>high){
          //         root=root.left;
          //     }
          //     return root;  
          // } 
    }
}
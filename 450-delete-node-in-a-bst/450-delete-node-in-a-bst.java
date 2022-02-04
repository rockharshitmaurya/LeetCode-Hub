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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode node=root;
        if(root.val==key){
            return helper(root);
        }
        while(node!=null){
            TreeNode pre=node;
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                  node.left=helper(node.left);
                    break;
                }else node=node.left;
            }else{
                if(node.right!=null && node.right.val==key){
                  node.right=helper(node.right);
                    break;
                }else node=node.right;
            }
        }
        return root;
    }
    // void delete(TreeNode prev){
    //     TreeNode new_node=prev.left.right;
    //     if(new_node!=null){
    //         while(new_node.left!=null){
    //             new_node=new_node.left;
    //         }
    //         new_node.left=prev.left.left;
    //         prev.left=prev.left.right;
    //     }else{
    //         prev.left=prev.left.left;
    //     }
    // }
    TreeNode helper(TreeNode root){
        if(root.right==null){
            return root.left;
        }else if(root.left==null){
            return root.right;
        }else{
             TreeNode new_node=root.right;
            if(new_node!=null){
                while(new_node.left!=null){
                    new_node=new_node.left;
                }
                new_node.left=root.left;
             // System.out.println("if");
               return root.right;
            }else{
                System.out.println("else");
                return new_node;
            } 
        }
        
    }
}
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
               return helper(nums,0,nums.length-1);
    }
    TreeNode helper(int arr[],int l,int r){
        if(l>r) return null;
        
        int max=0,idx=r;
        for(int i=l; i<=r; i++){
            if(arr[i]>max){
                max=arr[i];
                idx=i;
            }
        } 
        // System.out.println("max : "+max+" index "+idx);
        TreeNode root=new TreeNode(max);
        root.right=helper(arr,idx+1,r);
        root.left=helper(arr,l,idx-1);
        return root;
    }
    // int[] getMax(int nums[],int l,int r){
    //     int max=0,idx=0;
    //     for(int i=l; i<=r; i++){
    //         if(nums[i]>max){
    //             max=nums[i];
    //             idx=i;
    //         }
    //     } 
    //     return new int[]{max,idx};
    // }
}

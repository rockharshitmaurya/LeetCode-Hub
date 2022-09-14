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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root,1,new int[10]);
    }
    
    int dfs(TreeNode root,int n,int arr[]){
        if(root==null) return 0;
        
        if(root.left==null && root.right==null){
            arr[root.val]++;
            if(check(arr,n)) {
              arr[root.val]--; 
              return 1;
            }
            arr[root.val]--; 
            return 0;
        }
        
        arr[root.val]++;
        int l=dfs(root.left,n+1,arr);
        int r=dfs(root.right,n+1,arr);
        arr[root.val]--;
        return l+r;
        
    }
    boolean check(int arr[],int n){
        // System.out.println(Arrays.toString(arr));
        int count=0;
        if(n%2==0){
            for(int i=1; i<10; i++){
                if(arr[i]%2==1) return false;
            }
          return true;
        }
        
        if(n%2==1){
            for(int i=1; i<10; i++){
                if(arr[i]%2==1) count++;
            }
        }
        return count==1;
    }
}
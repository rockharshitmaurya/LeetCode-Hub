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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        helper(map,root,0,0);
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> mp:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:mp.values()){
                while(pq.size()>0){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }   
        }
       return ans; 
    }
    void helper(TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map,TreeNode root,int len,int level){
        if(root==null) return;
        
        if(!map.containsKey(len)){
            map.put(len,new TreeMap<>());
        }
        
        if(!map.get(len).containsKey(level)){
            map.get(len).put(level,new PriorityQueue<>());
        }
        
        map.get(len).get(level).add(root.val);
        helper(map,root.left,len-1,level+1);
        helper(map,root.right,len+1,level+1);
    }
}
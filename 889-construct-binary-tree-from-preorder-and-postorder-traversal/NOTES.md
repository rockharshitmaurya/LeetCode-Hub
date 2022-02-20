https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/821268/C-Construct-tree-using-preorder-traversal-first
​
​
Best Explanation :)
​
**Iterative Solution**
​
```
public TreeNode constructFromPrePost(int[] pre, int[] post) {
Deque<TreeNode> q=new ArrayDeque<>();
q.offer(new TreeNode(pre[0]));
for(int i=1,j=0; i<pre.length; ++i){
TreeNode node=new TreeNode(pre[i]);
while(q.getLast().val==post[j]){
q.pollLast();
j++;
}
if(q.getLast().left==null) q.getLast().left=node;
else q.getLast().right=node;
q.offer(node);
}
return q.getFirst();
}
```
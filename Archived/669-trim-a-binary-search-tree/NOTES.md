```
public TreeNode trimBST(TreeNode root, int low, int high) {
if (root == null) return root;
//remove all the non range nodes
while(root.val < low || root.val > high) {
if(root.val < low) root = root.right;
if(root.val > high) root = root.left;
}
Stack<TreeNode> stack = new Stack<>();
stack.push(root);
boolean flag = false;
while(!stack.isEmpty()){
TreeNode node = stack.pop();
//fix the nodes to point to correct child
if (node.left != null && node.left.val < low){
node.left = node.left.right;
flag = true;
}
if (node.right != null && node.right.val > high){
node.right = node.right.left;
flag = true;
}
if (flag) stack.push(node);
else {
if(node.left != null) stack.push(node.left);
if(node.right != null) stack.push(node.right);
}
flag = false;
}
return root;
}
```
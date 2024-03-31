# The key idea is:
​
* We scan numbers from left to right, build the tree one node by one step;
* We use a stack to keep some (not all) tree nodes and ensure a decreasing order;
* For each number, we keep pop the stack until empty or a bigger number; The bigger number (if exist, it will be still in stack) is current number's root, and the last popped number (if exist) is current number's left child (temporarily, this relationship may change in the future); Then we push current number into the stack.
​
```
public TreeNode constructMaximumBinaryTree(int[] nums) {
Deque<TreeNode> stack = new LinkedList<>();
for(int i = 0; i < nums.length; i++) {
TreeNode curr = new TreeNode(nums[i]);
while(!stack.isEmpty() && stack.peek().val < nums[i]) {
curr.left = stack.pop();
}
if(!stack.isEmpty()) {
stack.peek().right = curr;
}
stack.push(curr);
}
return stack.isEmpty() ? null : stack.removeLast();
}
```
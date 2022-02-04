If the root is empty, the new tree node can be returned as the root node.
​
Otherwise compare root. val is related to the size of the target value:
​
If root.val is greater than the target value, indicating that the target value should be inserted into the left subtree of the root, and the problem becomes root. Insert the target value in the left and recursively call the current function;
If root.val is less than the target value, indicating that the target value should be inserted into the right subtree of the root, and the problem becomes root. Insert the target value in right and recursively call the current function.
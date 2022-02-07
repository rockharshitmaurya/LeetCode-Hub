* For each subtree to be BST, there needs to be min and max limits.
* Max node in left subtree must be < root value, and root value must be > min node in right subtree.
* On a subtree that can't meet the BST property, we need to set min to MIN_VALUE and max to MAX_VALUE to make sure its sum cannot contribute to the sum of its parent node.
https://youtu.be/5_AZcOOc-kM?si=fC6aupVCFgmHBBRh
Steps:
​
* Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
* Once the node is found, have to handle the below 4 cases
* node doesn't have left or right - return null
* node only has left subtree- return the left subtree
* node only has right subtree- return the right subtree
* node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            // Node temp=new Node(0),head=temp;
            Node temp=new Node(0);
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if(i==0){
                    temp=node;
                }else{
                    temp.next=node;
                    temp=node;
                }
                // temp.next = node;
                // temp = temp.next;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            // while (head != null) {
            //     System.out.print(head.val + " ");
            //     head = head.next;
            // }
            
        }
        return root;
    }
}

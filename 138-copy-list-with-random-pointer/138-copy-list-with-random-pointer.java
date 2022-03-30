/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       Node new_head=new Node(0);
       Node ans=new_head;
       Node temp=head;
        HashMap<Node,Integer> map=new HashMap<>();
        HashMap<Integer,Node> new_map=new HashMap<>();
        int i=0;
        while(temp!=null){
            new_head.next=new Node(temp.val);
            new_map.put(i,new_head.next);
            map.put(temp,i++);
            new_head=new_head.next;
            temp=temp.next;
        }
        temp=head;
        new_head=ans.next;
        HashMap<Integer,Integer> r_map=new HashMap<>();
        i=0;
        while(temp!=null){
            r_map.put(i++,map.get(temp.random));
            temp=temp.next;
        }
        temp=head;
        new_head=ans.next;
        // System.out.println(r_map);
        i=0;
        while(new_head!=null){
            new_head.random=new_map.get(r_map.get(i++));
            new_head=new_head.next;
        }
        return ans.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(0);
        ListNode temp=head,t_head=dummy;
        while(temp!=null){
            if(temp.val<x){
                t_head.next=new ListNode(temp.val);
                t_head=t_head.next;
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.val>=x){
                t_head.next=new ListNode(temp.val);
                t_head=t_head.next;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}
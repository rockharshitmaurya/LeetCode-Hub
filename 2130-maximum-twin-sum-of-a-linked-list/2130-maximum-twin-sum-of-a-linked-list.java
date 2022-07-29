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
    ListNode temp_head;
    public int pairSum(ListNode head) {
        temp_head=head;
        return sum(head);
    }
    
    int sum(ListNode head){
        if(head==null) return 0;
        
        int value=sum(head.next);
        int start=temp_head.val; temp_head=temp_head.next;
        int end=head.val;
        return Math.max(value,start+end);
    }
}
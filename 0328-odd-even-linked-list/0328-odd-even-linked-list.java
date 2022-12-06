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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode head1=odd,head2=even;
        int check=1;
        
        while(head!=null){
            if(check%2==1){
                head1.next=new ListNode(head.val);
                head1=head1.next;
            }else{
                head2.next=new ListNode(head.val);
                head2=head2.next;
            }
            head=head.next;
            check++;
        }
        if(even.next!=null) head1.next=even.next;
        
        return odd.next;
    }
}
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
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start=head;
        return helper(head);
    }
    
    boolean helper(ListNode head){
        if(head==null) return true;
        
        boolean ans=helper(head.next);
        
        ans= ans&(head.val==start.val);
        start=start.next;
        
        return ans;
    }
}
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

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;

        ListNode temp = head;

        while (count < k && temp != null) {
            count++;
            temp = temp.next;
        }

        if (count == k) {
            ListNode prev = reverseKGroup(temp, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            // head = prev;
            return prev;
        }

        return head;
    }
}

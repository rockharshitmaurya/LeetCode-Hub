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

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            len++;
        }
        return helper(head, 0, (len / k), ans, (len % k));
    }

    ListNode[] helper(ListNode head, int idx, int len, ListNode[] ans, int rem) {
        if (head == null) return ans;
        ans[idx] = head;
        
        ListNode prev = null;
        int toadd = rem > 0 ? 1 : 0;
        for (int i = 1; i <= (len + toadd) && head != null; i++) {
            prev = head;
            head = head.next;
        }
        prev.next = null;
        return helper(head, idx + 1, len, ans, Math.max(0, rem - 1));
    }
}

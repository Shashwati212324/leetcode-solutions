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
        // Dummy heads for two lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers for traversal
        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Traverse original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Important: end the 'after' list
        after.next = null;

        // Connect before list to after list
        before.next = afterHead.next;

        // Return new head
        return beforeHead.next;
    }
}
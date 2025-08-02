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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode m = list1, n = list2;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        m = list1;
        n = list2;

        while (m != null && n != null) {
            if (m.next == null || m.next.val > n.val) {
                ListNode temp2 = n.next;
                n.next = m.next;
                m.next = n;
                m = m.next;
                n = temp2;
            } else {
                m = m.next;
            }
        }

        return list1;
    }
}

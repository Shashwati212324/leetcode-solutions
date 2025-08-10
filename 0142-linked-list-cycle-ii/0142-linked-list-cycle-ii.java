// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if(head ==null || head.next == null){
//             return head;
//         }
//         ListNode s=head, f=head;
//         while(f!= null && f.next!=null){
//             s=s.next;
//             f=f.next.next;
//             if(s==f){
//                 break;
//             }
//         }
//         // If no cycle
//         if (f == null || f.next == null) {
//             return null;
//         }
//         s = head;
//         while (s != f) {
//             s = s.next;
//             f = f.next;
//         }
//         return s;
//     }
// }
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle found
                // Phase 2: find start of cycle
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr; // start of cycle
            }
        }

        // no cycle
        return null;
    }
}

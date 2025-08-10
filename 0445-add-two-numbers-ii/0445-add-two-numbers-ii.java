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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        ListNode ll1 =rev(l1), ll2 = rev(l2);

        while (ll1 != null || ll2 != null || carry != 0) {
            int v1 = (ll1 != null) ? ll1.val : 0;
            int v2 = (ll2 != null) ? ll2.val : 0;
            int sum = v1 + v2 + carry;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (ll1 != null) ll1 = ll1.next;
            if (ll2 != null) ll2 = ll2.next;
        }


        return rev(dummy.next);
    
    }
    public ListNode rev(ListNode node){
        if(node ==null || node.next == null){
            return node;
        }
        ListNode prev =null, cur = node;
        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev =cur;
            cur =temp;
        }
        return prev;
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rev = reverse(head);
        ListNode temp=rev;
        // Special case: removing the first node after reversal
        if (n == 1) {
            rev = rev.next;
            return reverse(rev);
        }
        for(int i=0; i<n-2;i++){
            temp= temp.next;
        }
        temp.next = temp.next.next;
        return reverse(rev);
    }
    public ListNode reverse(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode prev=null, cur= head;
        while(cur!=null){
            ListNode node =cur.next;
            cur.next =prev;
            prev=cur;
            cur= node;
        }
        return prev;
    }

}
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==null || left ==right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        ListNode s =dummy;
        //taking s to node just before left
        for (int i = 1; i < left; i++) {
            s = s.next;
        }
        ListNode m =s.next;
        ListNode n =m;
        for(int i =left; i<right; i++){
            n=n.next;
        }
        ListNode e =n.next;
        n.next=null;
        //reversal
        ListNode prev =null, cur= m;
        while(cur!=null){
            ListNode p= cur.next;
            cur.next =prev;
            prev =cur;
            cur=p;
        }
        s.next = prev; // prev is new head of reversed sublist
        m.next = e;    // m is now the tail of reversed sublist

        return dummy.next;

    }
}
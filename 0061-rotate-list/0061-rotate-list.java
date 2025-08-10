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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // Step 1: Find length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) return head;
        head = Rev(head);
        ListNode t =head;
        for(int i=1;i<k&& t!=null;i++){
            t=t.next;
        }
        ListNode l=t.next;
        t.next =null;
        ListNode m=Rev(l);
        head=Rev(head);
        ListNode x =head;
        while(x.next!= null){
            x=x.next;
        }
        x.next =m;
        return head;

    }
    public ListNode Rev(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev =null, cur =head;
        while(cur!= null){
            ListNode temp =cur.next;
            cur.next =prev;
            prev =cur;
            cur=temp;
        }
        return prev;
    }
}
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
    public ListNode reverseList(ListNode head) {
        ListNode node= head;
        return reversal(node);
    }
    private ListNode reversal(ListNode node){
        if(node==null || node.next == null){
            return node;
        }
        ListNode prev =null, present = node;
        while(present != null){
            ListNode temp = present.next;
            present.next = prev;
            prev = present;
            present = temp;
            if(temp!=null){
                temp = temp.next;
            }
        }
        return prev;
    }
}
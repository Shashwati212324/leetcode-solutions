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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        while(curr != null && curr.next !=null){
            ListNode prev = curr.next;
            if(curr.val == prev.val){
                curr.next = prev.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
}
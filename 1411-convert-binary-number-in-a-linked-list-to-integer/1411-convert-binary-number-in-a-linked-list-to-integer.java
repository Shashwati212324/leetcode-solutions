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
    public int getDecimalValue(ListNode head) {
        return tillLast(head , 0);
    }
    public int tillLast(ListNode temp , int result){
        if(temp == null){
            return result;
        }
        return tillLast(temp.next, (result << 1) | temp.val);
    }
}
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode l1 = head, l2 =midList(head);
        ListNode l3 = reverse(l2);
        ListNode f=l1, s =l3;
        while(f!= null && s!= null){
            if(f.val != s.val){
                return false;
            }
            f = f.next;
            s = s.next;
        }
        return true;
    }
    public ListNode midList(ListNode node){
        if(node==null || node.next == null){
            return node;
        }
        ListNode f =node, s=node , t=null;
        
        while(f!= null && f.next != null){
            t=s;
            s=s.next;
            f=f.next.next;
        }
        if(t.next!= null){
            t.next =null;
        }
        return s;

    }
    public ListNode reverse(ListNode node){
        if(node== null || node.next == null){
            return node;
        }
        ListNode pre = null, curr = node;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //---------------Approach -1 Linked List -------------------
        // if(head == null|| head.next==null){
        //     return 0;
        // }
        // ListNode fast = head;
        // ListNode slow = head;
        // int count =0;
        // while(fast != null && fast.next != null){
        //     fast = fast.next.next;
        //     slow=slow.next;
        //     if(slow==fast){
        //         count =1;
        //         slow = slow.next;
        //         while(slow!=fast){
        //             count++;
        //             slow=slow.next;
        //         }
        //         count = count+1;
        //     }
            
        // }
        // return count;

        //---------------Approach -2 HashSet--------------
        if(head == null || head.next == null){
            return false;
        }
        ListNode temp = head;
        HashSet<ListNode> set = new HashSet<>();
        while(temp!= null){
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
         
    }
}
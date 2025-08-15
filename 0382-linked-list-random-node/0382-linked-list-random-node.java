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
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random(); // initialize here
    }

    public int getRandom() {
        int count = 0, result = -1;
        ListNode curr = head;
        while (curr != null) {
            count++;
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            curr = curr.next;
        }
        return result;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
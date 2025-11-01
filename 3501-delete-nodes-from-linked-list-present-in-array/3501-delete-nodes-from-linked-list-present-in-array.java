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

import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Store all elements of nums in a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Create a dummy node to handle deletions at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Traverse the linked list
        ListNode curr = dummy;
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                // Skip the node with value present in nums
                curr.next = curr.next.next;
            } else {
                // Move to the next node
                curr = curr.next;
            }
        }

        // Step 4: Return the updated head
        return dummy.next;
    }
}

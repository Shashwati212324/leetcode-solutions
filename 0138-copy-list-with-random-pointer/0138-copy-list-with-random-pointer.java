/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Interleave cloned nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // 2. Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Unweave to separate the cloned list
        curr = head;
        Node clonedHead = head.next;
        while (curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            clone.next = (clone.next != null) ? clone.next.next : null;
            curr = curr.next;
        }

        return clonedHead;
    }
}

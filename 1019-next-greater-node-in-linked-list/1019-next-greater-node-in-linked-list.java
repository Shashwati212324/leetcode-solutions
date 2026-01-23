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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            list.add(temp.val);
            temp= temp.next;
        }
        int n =list.size();
        int ans[] = new int[n];

        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && list.get(i)>list.get(stack.peek())){
                ans[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        return ans;
    }
}
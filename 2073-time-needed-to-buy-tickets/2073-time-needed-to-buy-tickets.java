class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new ArrayDeque<>();

        // store indices, not ticket values
        for (int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }

        int time = 0;

        while (true) {
            int person = q.poll();
            tickets[person]--;   // buys one ticket
            time++;

            // if this person is done
            if (tickets[person] == 0) {
                if (person == k) {
                    return time;
                }
            } else {
                // still needs tickets → go back
                q.offer(person);
            }
        }
    }
}

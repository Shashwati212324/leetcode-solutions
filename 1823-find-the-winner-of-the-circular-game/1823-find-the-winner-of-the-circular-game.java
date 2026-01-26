class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q= new ArrayDeque<>();
        for(int i =1; i<=n; i++){
            q.offer(i);
        }
        int s= n;
        // simulate elimination
        while (q.size() > 1) {

            // move k-1 people to back
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }

            // eliminate k-th person
            q.poll();
        }

        return q.peek();

        // Math optimized
        // int winner = 0;  // 0-based index
        // for (int i = 2; i <= n; i++) {
        //     winner = (winner + k) % i;
        // }
        // return winner + 1;
    }
}
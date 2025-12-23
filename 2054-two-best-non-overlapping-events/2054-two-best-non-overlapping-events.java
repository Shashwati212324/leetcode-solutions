class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort by end time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        // Prefix max of values
        int[] prefixMax = new int[n];
        prefixMax[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            // Binary search last event ending < start
            int l = 0, r = i - 1;
            int bestPrev = 0;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (events[mid][1] < start) {
                    bestPrev = prefixMax[mid];
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            ans = Math.max(ans, value + bestPrev);
        }

        return ans;
    }
}



class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;  // max possible minutes
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRun(mid, n, batteries)) {
                ans = mid;
                left = mid + 1;   // try for larger time
            } else {
                right = mid - 1;  // try smaller time
            }
        }

        return ans;
    }

    private boolean canRun(long T, int n, int[] batteries) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, T);
        }

        return total >= (long)n * T;
    }
}

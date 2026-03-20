import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int rows = m - k + 1;
        int cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> set = new TreeSet<>();

                // Collect all values from the current k x k submatrix
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        set.add(grid[r][c]);
                    }
                }

                // If only one distinct value exists, min abs difference is 0
                if (set.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }

                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;

                for (int val : set) {
                    if (prev != null) {
                        minDiff = Math.min(minDiff, val - prev);
                    }
                    prev = val;
                }

                ans[i][j] = minDiff;
            }
        }

        return ans;
    }
}
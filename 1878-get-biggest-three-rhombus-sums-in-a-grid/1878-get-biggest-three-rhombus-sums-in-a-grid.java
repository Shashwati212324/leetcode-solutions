import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // radius 0 rhombus
                set.add(grid[i][j]);

                // try bigger rhombuses
                int maxRadius = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                for (int k = 1; k <= maxRadius; k++) {
                    int sum = 0;

                    int r = i - k, c = j; // top

                    // top -> right
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + t][c + t];
                    }

                    // right -> bottom
                    r = i;
                    c = j + k;
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + t][c - t];
                    }

                    // bottom -> left
                    r = i + k;
                    c = j;
                    for (int t = 0; t < k; t++) {
                        sum += grid[r - t][c - t];
                    }

                    // left -> top
                    r = i;
                    c = j - k;
                    for (int t = 0; t < k; t++) {
                        sum += grid[r - t][c + t];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];
        int idx = 0;

        for (int val : set) {
            if (idx == 3) break;
            ans[idx++] = val;
        }

        return ans;
    }
}
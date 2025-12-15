import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;

        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        int diff = (sumA - sumB) / 2;

        HashSet<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) {
            bobSet.add(b);
        }

        for (int x : aliceSizes) {
            int y = x - diff;
            if (bobSet.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[0]; // guaranteed answer exists
    }
}

class Solution {
    public char findKthBit(int n, int k) {
        return dfs(n, k);
    }

    private char dfs(int n, int k) {
        if (n == 1) return '0';

        int len = (1 << n) - 1;      // 2^n - 1
        int mid = (len / 2) + 1;     // 2^(n-1)

        if (k == mid) return '1';

        if (k < mid) {
            return dfs(n - 1, k);
        } else {
            int mirror = len - k + 1;      // position in left half
            char bit = dfs(n - 1, mirror); // get bit from S(n-1)
            return invert(bit);            // right half is inverted
        }
    }

    private char invert(char c) {
        return (c == '0') ? '1' : '0';
    }
}
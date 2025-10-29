class Solution {
    public int smallestNumber(int n) {
        int k = 1;
        while (true) {
            int val = (1 << k) - 1; // 2^k - 1
            if (val >= n) return val;
            k++;
        }
            
    }
}
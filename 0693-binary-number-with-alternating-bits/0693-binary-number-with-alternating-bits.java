class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n % 2;
        n = n / 2;
        // Traverse through remaining bits
        while (n > 0) {
            int curr = n % 2;
            // If current bit is same as previous
            if (curr == prev)
                return false;
            prev = curr;
            n = n / 2;
        }
        return true;
        
    }
}
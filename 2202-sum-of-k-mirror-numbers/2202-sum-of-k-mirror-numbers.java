class Solution {
    // Convert number to base-k string
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    // Build palindromes dynamically in increasing order
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long half = (long) Math.pow(10, (length - 1) / 2); 
                 half < (long) Math.pow(10, (length + 1) / 2) && count < n; 
                 half++) {

                // Build palindrome
                String s = Long.toString(half);
                String rev = new StringBuilder(s.substring(0, length / 2)).reverse().toString();
                long pal = Long.parseLong(s + rev);

                if (isPalindrome(toBaseK(pal, k))) {
                    sum += pal;
                    count++;
                }
            }
            length++;
        }

        return sum;
    }
}

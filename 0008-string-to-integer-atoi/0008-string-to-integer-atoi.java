class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        // Step 1: Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // Step 2: Skip leading zeros
        while (i < s.length() && s.charAt(i) == '0') {
           i++;
        }
        int num = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;

            int digit = c - '0';

            // Overflow check before multiplying
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }   
        return sign*num;
    }


    
}
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // from LSB to just after MSB (i > 0)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 0) {
                // even: divide by 2
                steps += 1;
            } else if (bit == 1) {
                // odd: +1 then /2
                steps += 2;
                carry = 1;
            } else { // bit == 2
                // even: /2
                steps += 1;
                carry = 1;
            }
        }

        // If after processing all lower bits we still have carry,
        // it means MSB became 2 -> needs one extra step.
        return steps + carry;
    }
}
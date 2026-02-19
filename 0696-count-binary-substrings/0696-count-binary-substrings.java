class Solution {
    public int countBinarySubstrings(String s) {
        int prevCount = 0;  // Length of the previous group
        int currCount = 1;  // Length of the current group (first character counts as 1)
        int result = 0;     // To store total valid substrings

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // Same character, increase current group length
                currCount++;
            } else {
                // Character changed: add min(prevCount, currCount) to result
                result += Math.min(prevCount, currCount);
                prevCount = currCount; // current group becomes previous
                currCount = 1;         // reset current group
            }
        }

        // Add the last pair of groups
        result += Math.min(prevCount, currCount);

        return result;
    }
}

class Solution {
    public boolean checkOnesSegment(String s) {
       for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '1') {
                return false; // More than one segment of '1's
            }
        }
        return true;
    }
}
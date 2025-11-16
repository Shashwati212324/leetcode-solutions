class Solution {
    public int minLengthAfterRemovals(String s) {
        int A = 0, B = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') A++;
            else B++;
        }

        return Math.abs(A - B);
    }
}
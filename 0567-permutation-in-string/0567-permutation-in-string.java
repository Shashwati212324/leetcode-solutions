class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if (n > m) return false;

        int[] freq1 = new int[26];  // s1 count
        int[] freq2 = new int[26];  // window count

        for (char c : s1.toCharArray())
            freq1[c - 'a']++;

        // first window
        for (int i = 0; i < n; i++)
            freq2[s2.charAt(i) - 'a']++;

        if (Arrays.equals(freq1, freq2)) return true;

        // sliding window
        for (int i = n; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;         // add new char
            freq2[s2.charAt(i - n) - 'a']--;     // remove old char

            if (Arrays.equals(freq1, freq2))
                return true;
        }

        return false;
    }
}

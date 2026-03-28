class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0, len = 0, maxlen = 0, f = 0;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            count = Math.max(count, map.get(s.charAt(i)));
            len = i - j + 1;
            f = len - count;

            while (f > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
                len = i - j + 1;
                f = len - count;
            }

            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}
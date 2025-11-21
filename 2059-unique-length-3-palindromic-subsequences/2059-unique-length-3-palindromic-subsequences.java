class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> uniquePalindromes = new HashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch); 
            int last = s.lastIndexOf(ch);
            if (first != -1 && last != -1 && first < last) {
                for (int i = first + 1; i < last; i++) {
                    uniquePalindromes.add("" + ch + s.charAt(i) + ch);
                }
            }
        }
        
        return uniquePalindromes.size();
    }
}
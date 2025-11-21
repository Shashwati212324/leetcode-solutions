class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        String[] arr = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, new StringBuilder(), digits, arr, result);
        return result;
    }

    private void backtrack(int index, StringBuilder sb, String digits, String[] arr, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = arr[digit];

        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            backtrack(index + 1, sb, digits, arr, result);
            sb.deleteCharAt(sb.length() - 1);  // backtrack
        }
    }
}

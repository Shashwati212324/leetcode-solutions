class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) { 
                    result.append(ch); // skip outermost '('
                }
                stack.push(ch);
            } else { // ch == ')'
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(ch); // skip outermost ')'
                }
            }
        }

        return result.toString();
    }
    
}
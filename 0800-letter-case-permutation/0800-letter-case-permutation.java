class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        backtrack(0, new StringBuilder(), list, s);
        return list;
    }

    public void backtrack(int index, StringBuilder temp, List<String> list, String s){
        if(index == s.length()){
            list.add(temp.toString());
            return;
        }

        char ch = s.charAt(index);

        if(Character.isDigit(ch)){
            temp.append(ch);
            backtrack(index + 1, temp, list, s);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            // Lowercase branch
            temp.append(Character.toLowerCase(ch));
            backtrack(index + 1, temp, list, s);
            temp.deleteCharAt(temp.length() - 1);

            // Uppercase branch
            temp.append(Character.toUpperCase(ch));
            backtrack(index + 1, temp, list, s);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

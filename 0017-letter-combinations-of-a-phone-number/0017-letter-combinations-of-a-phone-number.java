class Solution {
    public List<String> letterCombinations(String digits) {
        String[] array = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(array, sb, list, digits);
        return list;
    }
    public void backtrack(String[] ar, StringBuilder sb, List<String> list, String digits){
        if(sb.length() == digits.length()){
            list.add(sb.toString());
            return;
        }
        int index= sb.length();
        int digit = digits.charAt(index)-'0';
        String s = ar[digit];

        for(char ch: s.toCharArray()){
            sb.append(ch);
            backtrack(ar,sb,list,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

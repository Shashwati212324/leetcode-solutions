class Solution {
    List<List<String>> answer = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return answer;        
    }
    public void backtrack(String s, int start){
        if (start == s.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (palindromeCheck(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backtrack(s, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
    public boolean palindromeCheck(String str, int s, int e){
        
        int i=s, j = e;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    
}
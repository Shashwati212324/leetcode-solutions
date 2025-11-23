class Solution {
    List<List<String>> list = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return list;
    }
    public void backtrack(String s, int index){
        if(index == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                backtrack(s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
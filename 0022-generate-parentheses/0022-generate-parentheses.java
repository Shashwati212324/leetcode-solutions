class Solution {
    public List<String> generateParenthesis(int n) {
        String s ="";
        List<String> list= new ArrayList<>();
        backtrack(n,s,0,0,list);
        return list;

    }
    public void backtrack(int n, String s, int open, int close,List<String> list ){
        if(s.length()==2*n){
            list.add(s);
            return;
        }
        if(open<n){
            backtrack(n,s+"(",open+1,close,list);
        }
        if(close<open){
            backtrack(n,s+")",open,close+1,list);
        }
    }
}
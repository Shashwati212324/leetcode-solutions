class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int close =0,start=0;
        backtrack(sb, list, n,close,start);
        return list;
    }
    public void backtrack(StringBuilder sb, List<String> list, int n, int close,int start){
        if(sb.length() == 2*n){
            list.add(sb.toString());
            return;
        }
        
        if(start<n){
            sb.append('(');
            backtrack(sb,list,n,close,start+1);
            int l =sb.length()-1;
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close<start){
            sb.append(')');
            backtrack(sb,list,n,close+1,start);
            sb.deleteCharAt(sb.length() - 1);
        }

        
    }
}
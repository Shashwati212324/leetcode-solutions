class Solution {
    public String getHappyString(int n, int k) {
       // StringBuilder() sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        char[] ch = {'a','b','c'};
        backtrack(n,new StringBuilder(),list, ch);
        if(k>list.size())return "";
        return list.get(k-1);
        
    }
    public static void backtrack(int n, StringBuilder sb, List<String> list, char[] ch){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }
        for(int i =0; i<ch.length; i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==ch[i])continue;
            sb.append(ch[i]);
            backtrack(n,sb,list,ch);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
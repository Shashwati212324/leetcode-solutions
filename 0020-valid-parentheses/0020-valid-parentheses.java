class Solution {
    public boolean isValid(String s) {
        //s=s.trim();
        if(s.equals(""))return true;
        Stack<Character> stack= new Stack<>();
        for(int i =0; i<s.length();i++){
            char c= s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())return false;
                char ch = stack.pop();
                if(c==')' && ch !='(')return false;
                if(c=='}' && ch !='{')return false;
                if(c==']' && ch !='[')return false;
            }
        }   
        return stack.isEmpty();
    }
}

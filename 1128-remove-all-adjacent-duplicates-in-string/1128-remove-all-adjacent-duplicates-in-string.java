class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int ptr =0;
        char[] ar = s.toCharArray();
        stack.push(ar[0]);
        for(int i =1; i<ar.length ; i++){
            if(!stack.isEmpty()){
                if(stack.peek() == ar[i]){
                    stack.pop();
                }
                else{
                    stack.push(ar[i]);
                }
            }else{
                stack.push(ar[i]);
            }
            
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
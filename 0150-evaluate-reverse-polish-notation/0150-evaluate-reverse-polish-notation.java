class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<tokens.length; i++){
            if(tokens[i].equals( "+") ){
                stack.push(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("*") ){
                stack.push(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/")){
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2/pop1);

            }
            else if(tokens[i].equals("-")){
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2-pop1);

            }
            else{
                int k = Integer.parseInt(tokens[i]);
                stack.push(k);
            }

        }
        return stack.pop();
    }
}
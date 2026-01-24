class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> stack =  new Stack<>();
        StringBuilder str = new StringBuilder();

        int num =0;
        for(char ch: s.toCharArray()){
            //determining k
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }
            //when u encounter '['
            else if(ch == '['){
                nums.push(num);
                stack.push(str);
                num=0;
                str = new StringBuilder();
            }
            //when u encounter ']'
            else if(ch == ']'){
                int k = nums.pop();
                StringBuilder ss = stack.pop();
                for(int i =0; i<k ; i++){
                    ss.append(str);
                }
                str=ss;
            }
            else{
                str.append(ch);
            }
        }
        return str.toString();
    }
}
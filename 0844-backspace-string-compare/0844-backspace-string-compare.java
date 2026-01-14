class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Stack<Character> stack1 = new Stack<>();
        // Stack<Character> stack2 = new Stack<>();
        // for(int i =0; i<s.length(); i++){
        //     char c = s.charAt(i);
        //     if(c=='#'){
        //         if(!stack1.isEmpty()){
        //             stack1.pop();
        //         }
                
        //     }else{
        //         stack1.push(c);
        //     }
        // }
        // for(int i =0; i<t.length(); i++){
        //     char c = t.charAt(i);
        //     if(c=='#'){
        //         if(!stack2.isEmpty()){
        //             stack2.pop();
        //         }
        //     }else{
        //         stack2.push(c);
        //     }
        // }
        // return stack1.equals(stack2);

        int i =s.length()-1;
        int j =t.length()-1;
        int ss=0,tt=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    ss++;
                    i--;
                }else if(ss>0){
                    ss--;
                    i--;
                }else{
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    tt++;
                    j--;
                }else if(tt>0){
                    tt--;
                    j--;
                }else{
                    break;
                }
            }
            if(i>=0 && j>=0){
                if(s.charAt(i)!=t.charAt(j))return false;
            }else if(i>=0 || j>=0){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
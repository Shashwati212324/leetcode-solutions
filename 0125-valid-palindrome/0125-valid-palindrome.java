class Solution {
    public boolean isPalindrome(String s) {
        //APPROACH 1
        // int u =0;
        // int l = s.length()-1;
        
        // while(u<l){
        //     char ch1 = (char)s.charAt(u);
        //     char ch2 = (char)s.charAt(l);
        //     if(ch1>='A' && ch1<='Z'){ 
        //         ch1= (char)(ch1+32);
        //     }
        //     if(ch2>='A' && ch2<='Z'){ 
        //         ch2= (char)(ch2+32);
        //     }
            
        //     if(!((ch1 >= 'a' && ch1<= 'z')||(ch1>='0'&&ch1<='9'))){
        //         u++;
        //         continue;
        //     }
        //     if(!((ch2 >= 'a' && ch2<= 'z')||(ch2>='0'&&ch2<='9'))){
        //         l--;
        //         continue;
        //     }
        //     if(ch1 != ch2){
        //         return false;
        //     }
        //     u++;
        //     l--;
        // }
        // return true;

        //APPROACH -2
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                dq.offerLast(Character.toLowerCase(ch));
            }
        }
        while (dq.size() > 1) {
            if (!dq.pollFirst().equals(dq.pollLast())) {
                return false;
            }
        }
        return true;
        
    }
}
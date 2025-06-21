class Solution {
    public String addBinary(String a, String b) {
        int al =a.length()-1;
        int bl =b.length()-1;
        int i=al, j=bl;
        int carry =0;
        StringBuilder s = new StringBuilder();
        while(i>=0||j>=0){
            char ai = (i >= 0) ? a.charAt(i) : '0';
            char bj = (j >= 0) ? b.charAt(j) : '0';
            if((ai == '1')&&(bj=='1')){
                if(carry == 1){
                    s.append('1');
                }
                else{
                    s.append('0');
                }
                carry=1;
            }
            else if((ai == '0')&&(bj=='0')){
                if(carry==1){
                    s.append('1');
                    carry=0;
                }
                else{
                    s.append('0');
                }
            }
            else{
                if(carry==1){
                    s.append('0');
                    carry=1;
                }
                else{
                    s.append('1');
                    carry=0;
                }
            }
            i--;
            j--;
        }
        if(carry == 1){
            s.append('1');

        }
        return s.reverse().toString();


        // StringBuilder sb = new StringBuilder();
        
        // int i = a.length() - 1;
        // int j = b.length() - 1;
        // int carry = 0;
        // while (i >= 0 || j >= 0 || carry == 1) {
        //     int sum = carry;

        //     if (i >= 0) sum += a.charAt(i--) - '0';
        //     if (j >= 0) sum += b.charAt(j--) - '0';

        //     sb.append(sum % 2);  // add result bit
        //     carry = sum / 2;     // update carry
        // }
        // return sb.reverse().toString();
    }
}
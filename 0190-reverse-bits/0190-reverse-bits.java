public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String str ="";
        for(int i =0; i<32;i++){
            if((n&(1<<i))!=0){
                str+=1;
            }
            else{
                str+=0;
            }
        }
        return binarytoDecimal(str);
    }
    public int binarytoDecimal(String n) {
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            result = result * 2 + (n.charAt(i) - '0');
        }
        return result;
    }
}
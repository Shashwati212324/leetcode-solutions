public class Solution {
   
     public int reverseBits(int n) {

         // you need treat n as an unsigned value
    //-------------Brute force-----------------
    //     String str ="";
    //     for(int i =0; i<32;i++){
    //         if((n&(1<<i))!=0){
    //             str+=1;
    //         }
    //         else{
    //             str+=0;
    //         }
    //     }
    //     return binarytoDecimal(str);
    // }
    // public int binarytoDecimal(String n) {
    //     int result = 0;
    //     for (int i = 0; i < n.length(); i++) {
    //         result = result * 2 + (n.charAt(i) - '0');
    //     }
    //     return result;

        //optimized
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space
            result |= (n & 1);     // copy last bit of n
            n >>>= 1;              // unsigned right shift
        }

        return result;
    }
}
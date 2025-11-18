class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int count =0;
       for(int i =0; i<bits.length ;i++){
        if(bits[i] == 1){
            i=i+1;
            count=2;
        }
        else{
            count=1;
        }
       } 
       return (count==1);
    }
}
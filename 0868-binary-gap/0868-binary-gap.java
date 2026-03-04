class Solution {
    public int binaryGap(int n) {
        int temp =-1;
        int gap =0;
        int count =0;
       
        while(n>0){
            if((n&1)==1){
                if (temp != -1) {
                    gap = Math.max(gap, count-temp);
                }
                temp = count;
            }
            count++;
            n=n>>1;
        }    
        return gap;

    }
}
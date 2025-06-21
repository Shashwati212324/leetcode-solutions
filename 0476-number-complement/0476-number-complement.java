class Solution {
    public int findComplement(int num) {
        int x = num;
        int i =0;
        while(x>0){
            num=num^(1<<i);
            x=x>>1;
            i++;
            
        }
        return num;
    }
}
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        int m=1;
        int x=n;
        while(x>0){
            m<<=1;
            x>>=1;
        }
        return m-n-1;
    }
}
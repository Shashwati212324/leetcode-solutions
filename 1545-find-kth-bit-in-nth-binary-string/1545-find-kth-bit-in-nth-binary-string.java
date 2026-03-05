class Solution {
    public char findKthBit(int n, int k) {
        return solve(n,k);
    }
    public static char solve(int n, int k){
        int len = (1<<n)-1;
        int mid = len/2 +1;
        if(k == 1)return '0';

        if(k==mid)return '1';
        else if(k<mid){
            return solve(n-1,k);
        }
        else{
            int mirror = len - k + 1;
            char c = solve(n-1, mirror);
            c = (c=='0')?'1':'0';
            return c;
        }
        
        
    }
}
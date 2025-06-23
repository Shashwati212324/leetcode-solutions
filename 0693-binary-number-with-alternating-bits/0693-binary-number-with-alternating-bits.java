class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean ans = false;
        int x = n;
        int i =0;
        while(x>0){
            int j=i+1;
            if(((n>>i)&1) == ((n>>j)&1)){
                return false;
            }else{
                ans=true;
            }
            x=x>>1;
            i=i+1;
        }
        return ans;
        
    }
}
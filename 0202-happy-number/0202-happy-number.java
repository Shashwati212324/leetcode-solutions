class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = Sum(n);

        while (y != 1 && x != y) {
            x = Sum(x);
            y = Sum(Sum(y));
        }
        return y == 1;
    }

    public int Sum(int n) {
        int sum =0;
        while(n != 0){
            int x =(n%10);
            sum+=(x*x);
            n=n/10;
        } 
        return sum;
    }
    
}
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = Sum(n);

        while (fast != 1 && slow != fast) {
            slow = Sum(slow);
            fast = Sum(Sum(fast));
        }
        return fast == 1;
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
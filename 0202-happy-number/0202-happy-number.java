import java.util.*;
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            if(!set.add(n)){
                return false;
            }
            n=Sum(n);
        }
        return true;
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
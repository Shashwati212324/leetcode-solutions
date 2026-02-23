import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        
        int totalNeeded = 1 << k;
        if (n - k + 1 < totalNeeded) return false;
        
        HashSet<Integer> set = new HashSet<>();
        int num = 0;
        
        for (int i = 0; i < n; i++) {
            num = ((num << 1) & ((1 << k) - 1)) | (s.charAt(i) - '0');
            
            if (i >= k - 1) {
                set.add(num);
                if (set.size() == totalNeeded) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
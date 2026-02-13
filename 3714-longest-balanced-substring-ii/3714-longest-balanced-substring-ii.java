import java.util.*;

class Solution {
    
    public int longestBalanced(String s) {
        
        int maxLen = 0;
        
        // Case 1: single character
        maxLen = Math.max(maxLen, longestSingleChar(s));
        
        // Case 2: two distinct characters
        maxLen = Math.max(maxLen, solveTwoChar(s, 'a', 'b'));
        maxLen = Math.max(maxLen, solveTwoChar(s, 'a', 'c'));
        maxLen = Math.max(maxLen, solveTwoChar(s, 'b', 'c'));
        
        // Case 3: all three characters
        maxLen = Math.max(maxLen, solveThreeChar(s));
        
        return maxLen;
    }
    
    
    // Case 1
    private int longestSingleChar(String s) {
        int max = 1;
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
    
    
    // Case 2
    private int solveTwoChar(String s, char x, char y) {
        
        int max = 0;
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            
            // Skip third character
            if (s.charAt(i) != x && s.charAt(i) != y) {
                i++;
                continue;
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            
            int cx = 0, cy = 0;
            int start = i;
            
            while (i < n && (s.charAt(i) == x || s.charAt(i) == y)) {
                
                if (s.charAt(i) == x) cx++;
                else cy++;
                
                int diff = cx - cy;
                
                if (map.containsKey(diff)) {
                    max = Math.max(max, i - (start + map.get(diff)));
                } else {
                    map.put(diff, i - start);
                }
                
                i++;
            }
        }
        
        return max;
    }
    
    
    // Case 3
    private int solveThreeChar(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        
        int a = 0, b = 0, c = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;
            
            int d1 = b - a;
            int d2 = c - a;
            
            String key = d1 + "#" + d2;
            
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        
        return max;
    }
}

class Solution {
    public int longestPalindrome(String s) {
        int count =0;
        if(s.length() == 1 || s.length()==0){
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int val: map.values()){
            if(val%2==0){
                count += val;
            }
            else {
                count += val-1;
            }
        }
        if(count<s.length()){
            count++;
        }
        return count;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len =0;
        int j=0;
        int l = s.length()-1;

        for(int i =0; i<s.length(); i++){
            while(map.containsKey(s.charAt(i))){
                map.remove(s.charAt(j));
                j++;
            }
            map.put(s.charAt(i),1);
            len = Math.max(len, map.size());

        }
        return len;


        
    }
}
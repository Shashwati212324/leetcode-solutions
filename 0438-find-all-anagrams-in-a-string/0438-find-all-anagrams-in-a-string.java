class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for(char ch:p.toCharArray()){
            pFreq[ch-'a']++;
        }
        int left =0;
        int k=p.length();
        for(int i =0; i<s.length();i++){
            sFreq[s.charAt(i)-'a']++;

            if(i-left+1>k){
                sFreq[s.charAt(left)-'a']--;
                left++;
            }
            if(i-left+1 ==k && Arrays.equals(pFreq,sFreq)){
                list.add(left);
            }
        }
        return list;
    }
}
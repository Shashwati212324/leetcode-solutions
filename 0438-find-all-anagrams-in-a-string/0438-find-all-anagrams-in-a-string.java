class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) return list;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map1.put(p.charAt(i), map1.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            if (j - i + 1 > p.length()) {
                char leftChar = s.charAt(i);
                map2.put(leftChar, map2.get(leftChar) - 1);
                if (map2.get(leftChar) == 0) {
                    map2.remove(leftChar);
                }
                i++;
            }

            if (j - i + 1 == p.length() && map1.equals(map2)) {
                list.add(i);
            }
        }

        return list;
    }
}

        // List<Integer> list = new ArrayList<>();
        // int[] sFreq = new int[26];
        // int[] pFreq = new int[26];

        // for(char ch:p.toCharArray()){
        //     pFreq[ch-'a']++;
        // }
        // int left =0;
        // int k=p.length();
        // for(int i =0; i<s.length();i++){
        //     sFreq[s.charAt(i)-'a']++;

        //     if(i-left+1>k){
        //         sFreq[s.charAt(left)-'a']--;
        //         left++;
        //     }
        //     if(i-left+1 ==k && Arrays.equals(pFreq,sFreq)){
        //         list.add(left);
        //     }
        // }
        // return list;



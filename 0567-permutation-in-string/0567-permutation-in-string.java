class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(map2.equals(map1))return true;
       
        int n= s1.length()-1;
        int i=0;
        for(int j =n+1;j<s2.length();j++){
           map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j),0)+1);
           map2.put(s2.charAt(i),map2.get(s2.charAt(i))-1);
           if(map2.get(s2.charAt(i))==0)map2.remove(s2.charAt(i));

           if(map2.equals(map1))return true;
           i++;
           
        }
        return map2.equals(map1);
    }
}

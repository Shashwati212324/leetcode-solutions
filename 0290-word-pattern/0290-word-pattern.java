class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap< Character,String> map2 = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length != pattern.length())return false;
        for(int i =0; i<pattern.length(); i++){
            
            if(map2.containsKey(pattern.charAt(i))){
                if(!map2.get(pattern.charAt(i)).equals(str[i]))return false;
            }
            else{
                map2.put(pattern.charAt(i),str[i]);
            }
            if(map1.containsKey(str[i])){
                if(!map1.get(str[i]).equals(pattern.charAt(i)))return false;
            }
            else{
                map1.put(str[i],pattern.charAt(i));
            }
        }
        return true;
    }
}
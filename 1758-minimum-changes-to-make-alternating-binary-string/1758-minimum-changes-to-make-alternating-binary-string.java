class Solution {
    public int minOperations(String s) {
       int oalt = OAlt(s);
       int alt1 = OneAlt(s);
       return Math.min(oalt, alt1);
    }
    public static int OAlt(String s){
        int step =0;
        char[] c = s.toCharArray();
        for(int i =0; i<c.length ;i++){
            if(i%2==0 && c[i]!='0')step++;
            if(i%2!=0 && c[i]!='1')step++;
        }
        return step;
    }
    public static int OneAlt(String s){
        int step =0;
        char[] c = s.toCharArray();
        for(int i =0; i<c.length ;i++){
            if(i%2==0 && c[i]=='0')step++;
            if(i%2!=0 && c[i]=='1')step++;
        }
        return step;
    }
}
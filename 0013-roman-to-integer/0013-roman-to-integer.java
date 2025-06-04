class Solution {
    public int romanToInt(String s) {
        
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
    
    int i=-1;
    int no=0;
    int l = s.length()-1;
    for(i =0; i<l; i++){
        int j = i+1;
        int n1= values(s.charAt(i));
        int n2=values(s.charAt(j));
        if(n1<n2){
            no+=n2-n1;
            i++;
        }else{
            no+=n1;
        }
    }
    if(i==l){
        no+=values(s.charAt(i));
    }
    return no;
    
    }
    public static int values(char ch) {
        int num= -1;
        if(ch=='I'){
            num=1;
        }if (ch=='V') {
            num=5;
        }
        if (ch=='X') {
            num=10;
        }
        if (ch=='L') {
            num=50;
        }
        if (ch=='C') {
            num=100;
        }
        if (ch=='D') {
            num=500;
        }
        if (ch=='M') {
            num=1000;
        }
        return num;
    }
}
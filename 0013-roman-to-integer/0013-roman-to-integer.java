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
    
    int i=0;
    int no=0;
    int l = s.length();
    char[] ch = s.toCharArray();
    while(i<l-1){
        int j = i+1;
        if(values(ch[i])>=values(ch[j])){
            no+=values(ch[i]);
            i++;
        }else{
            no+=(values(ch[j])-values(ch[i]));
            i=i+2;
        }
    }
    // handle last character if not processed
    if (i == l - 1) {
        no += values(ch[i]);
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
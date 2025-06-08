class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list= new ArrayList<>();
        for(int i =left; i<=right; i++){
            if(check(i)){
               list.add(i); 
            }
        }
        return list;
    }
    public boolean check(int l) {
        int temp=l;
        //boolean a=false;
        while(temp>0){
            int x=temp%10;
            if(x==0 || l%x!=0){
                return false;
            }
            temp=temp/10;
        }
        return true;
    }
}
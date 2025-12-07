class Solution {
    public int countOdds(int low, int high) {
        int count =0;
        if(low%2==0){
            for(int i = low+1; i<=high; i+=2){
                count += 1;
            }
        }
        else{
            for(int i = low; i<=high; i+=2){
                count += 1;
            }
        }
        return count;
    }
}
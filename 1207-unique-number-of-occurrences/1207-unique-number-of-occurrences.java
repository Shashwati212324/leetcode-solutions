class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int x=1;
        for(int i =1; i<arr.length; i++){
            
            if(arr[i-1]==arr[i]){
                x++;
            }
            else{
                if(!set.add(x))
                    return false;
                x =1;
            }
            
            
        }
        return set.add(x);
    }
}
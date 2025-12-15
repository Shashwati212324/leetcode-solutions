class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        
        for(int i =0; i<arr.length; i++){
            int target = 2*arr[i];
            if( BS(arr, target, i) == true){
                return true;
            } 
        }
        return false;
        
    } 
    public static boolean BS(int[] arr, int target, int index){
        int s =0; int e = arr.length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] == target && mid != index){
                    return true;
                }
                else if(arr[mid]>target){
                    e= mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            return false;
    }   
}
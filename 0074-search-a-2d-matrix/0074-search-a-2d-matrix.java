class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int r = -1; 

        for(int i = 0; i < rows; i++){
            if(target >= matrix[i][0] && target <= matrix[i][columns - 1]){
                r = i;
                break;
            }
        }
        if(r == -1)return false;
        return binarySearch(matrix[r],target);
    }
    public boolean binarySearch(int[] arr, int target){
        int s =0, e =arr.length-1;
        
        while(s<=e){
            int mid =s+(e-s)/2;
            if(target <arr[mid])e=mid-1;
            else if(target>arr[mid])s=mid+1;
            else return true;
        }
        return false;
    }
}
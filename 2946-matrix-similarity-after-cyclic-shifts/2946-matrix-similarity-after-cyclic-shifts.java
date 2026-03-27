class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        // int rows = mat.length;
        // int cols = mat[0].length;
        // k %= cols;

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         int shiftedIndex;

        //         if (i % 2 == 0) {
        //             // even row: left shift by k
        //             shiftedIndex = (j + k) % cols;
        //         } else {
        //             // odd row: right shift by k
        //             shiftedIndex = (j - k + cols) % cols;
        //         }

        //         if (mat[i][j] != mat[i][shiftedIndex]) {
        //             return false;
        //         }
        //     }
        // }

        // return true;



        int rows= mat.length;
        int cols=mat[0].length;
        k = k % cols;
        // deep copy of original matrix
        int[][] original = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                original[i][j] = mat[i][j];
            }
        }
        for(int i =0; i<mat.length; i++){
            if(i%2!=0){
            for(int m =0; m<k;m++){
                RightShift(mat,i);
            }
            }
            else{
               for(int m =0; m<k;m++){
                   LeftShift(mat,i);
                } 
            } 
        }
        // compare with original
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != original[i][j]) {
                    return false;
                }
            }
        }

        return true;
        
    }
    public void RightShift(int[][] mat, int i){
        int l=mat[0].length, x =mat[i][l-1];
        for(int j =l-1; j>0; j--){
            mat[i][j]=mat[i][j-1];
        }
        mat[i][0]=x;
    }
    public void LeftShift(int[][] mat, int i){
        int l =mat[0].length,x=mat[i][0];
        for(int j =0; j<l-1 ;j++){
            mat[i][j]=mat[i][j+1];
        }
        mat[i][l-1]=x;        
    }
}
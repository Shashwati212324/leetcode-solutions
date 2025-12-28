class Solution {
    public int countNegatives(int[][] grid) {
        
        int count= 0;
        //Approach 1 - normal loop
        for(int r=0; r<grid.length;r++){
            int s = 0; int e = grid[r].length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
               if(grid[r][mid]<0){e = mid-1;}
                else{s=mid+1;}
            }
            count += (grid[r].length)-s;
            
        }
        //approach 2- optimized loop

        // for(int i =0; i<grid.length; i++){
        //     int l = grid[i].length;
        //     for(int j =0; j<grid[0].length; j++ ){
        //         if(grid[i][j]<0)count++;
        //         if(grid[i][0]>0 && grid[i][l-1]>0)break;
        //     }
        // }
        
        return count;
        

    }
}
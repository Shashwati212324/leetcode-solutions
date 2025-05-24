public class Solution {
    // public static void main(String[] args) {
    //     // Warm-up phase
    //     for (int i = 0; i < 300; i++) {
    //         majorityElement(new int[] {1, 2, 2, 3, 2, 2, 4});
    //     }

    // }//     // Benchmarking phase
    //     long startTime = System.nanoTime();
    //     System.out.println(majorityElement(new int[] {1, 2, 2, 3, 2, 2, 4}));
    //     long endTime = System.nanoTime();

    //     System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    // }

    public static int majorityElement(int[] nums) {
        int result =0;
       
        int major = 0;
        int j =0;
        if(nums.length == 1){
            return nums[0];
        }
        while(j<nums.length-1){
            int count =1;
            int temp = nums[j];
            if(temp != major){
                for(int i=j+1;i<nums.length;i++){
                    if(nums[i]==temp){
                        count++;
                    }
                    if(result<count){
                        result=count;
                        if(result>=nums.length/2){
                            major = temp;
                        }
                    }
                    
            
                }
            }
            j++;
        }
        return major;








    //     for(int i=0; i<nums.length-1; i++){
    //         for(int j =i+1; j>0;j--){
    //             if(nums[j]<nums[j-1]){
    //                 int temp = nums[j];
    //                 nums[j] = nums[j-1];
    //                 nums[j-1]= temp;
    //             }
    //         }
    //     }
    //     int count =1;
    //     int finalee = nums[0];
    //     for(int i =0; i<nums.length-1 ;i++){
    //         if(nums[i]==nums[i+1]){
    //             count++;
    //             if(count>nums.length/2){
    //                 finalee= nums[i];
    //             }
    //         }
    //         else{
    //             count = 1;
    //            // finalee = nums[i];
    //         }
            
    //     }
    //     return finalee;
    // }
    // public int majority(int[] arr){
        
        
    }
}

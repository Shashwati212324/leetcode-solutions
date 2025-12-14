import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // List<Integer> list1 = new ArrayList<>();
        // List<Integer> result = new ArrayList<>();

        // for (int num : nums1) {
        //     if (!list1.contains(num)) {
        //         list1.add(num); 
        //     }
        // }

        // // Check for intersections
        // for (int num : list1) {
        //     for(int i =0; i<nums2.length ; i++){
        //         if(num==nums2[i] && result.contains(num)==false){
        //             result.add(num);
        //         }
        //     }
        // }

        // // Convert List to int[]
        // int[] intersectionArray = new int[result.size()];
        // for (int i = 0; i < result.size(); i++) {
        //     intersectionArray[i] = result.get(i);
        // }

        // return intersectionArray;
        //-------------Approach -2 - HashSet------------
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int i =0; i<nums2.length ; i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        int index = 0;

for (int num : list) {
    arr[index++] = num;
}
        return arr;
    }
}

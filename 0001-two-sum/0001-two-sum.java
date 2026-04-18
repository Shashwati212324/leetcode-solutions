class Solution {
    public int[] twoSum(int[] nums, int target) {

        //TCS REVISION
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = target-nums[i];
            if(map.containsKey(x))return new int[]{i,map.get(x)};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};



        // List<Integer> al = new ArrayList<>();//----------------------ArrayList
        // int n =0; 
        // for(int i =0; i<nums.length-1; i ++){
        //     for(int j =i+1; j<nums.length ;j++){
        //         if(nums[i]+nums[j]==target){
        //             al.add(i);
        //             al.add(j);

        //             int[] arr = new int[al.size()];
        //             for(int k =0 ; k<al.size();k++){
        //                 arr[k] = al.get(k);
        //             }
        //             return arr;
        //         }    
                
        //     }
        // }
        // return new int[0];
        // HashMap<Integer, Integer> map = new HashMap<>();
        //  for (int i = 0; i < nums.length; i++) {
        //     int needed = target - nums[i];

        //     if (map.containsKey(needed)) {
        //         return new int[]{ map.get(needed), i };
        //     }

        //     map.put(nums[i], i);
        // }
        // return new int[]{0,0};
    }
}
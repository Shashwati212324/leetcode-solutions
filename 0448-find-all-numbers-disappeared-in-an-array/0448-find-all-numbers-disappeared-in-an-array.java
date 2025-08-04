class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        ArrayList ar = new ArrayList();
        // Edge case 1: Missing numbers at the beginning
        if(nums[0] > 1){
            for(int i = 1; i < nums[0]; i++){
                ar.add(i);
            }
        }
        for(int i =1; i<nums.length;i++){
            int a1 = nums[i-1];
            int a2 = nums[i];
            int diff= a2-a1;
            // Edge case 2: Skip duplicates, and find gaps
            if(a1!=a2 && diff>1){
                for(int j=0;j<diff-1;j++){
                    ar.add(a1+1);
                    a1+=1;
                   
                }
            }
        }
        // Edge case: Missing numbers at the end (e.g. [1,2,3] but n = 5 => 4 and 5 are missing)
        int n = nums.length;
        if(nums[n - 1] < n){
            for(int i = nums[n - 1] + 1; i <= n; i++){
                ar.add(i);
            }
        }
        return ar;
    }
}
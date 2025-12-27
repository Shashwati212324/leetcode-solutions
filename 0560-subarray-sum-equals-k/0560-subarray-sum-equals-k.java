class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // IMPORTANT: empty prefix

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            // Check if subarray ending here sums to k
            count += map.getOrDefault(prefixSum - k, 0);

            // Store prefix sum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

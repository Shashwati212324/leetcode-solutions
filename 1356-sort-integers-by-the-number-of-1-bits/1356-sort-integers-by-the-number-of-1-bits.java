import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] nums = new Integer[n];
        Map<Integer, Integer> bitCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
            bitCountMap.put(arr[i], Integer.bitCount(arr[i]));
        }

        Arrays.sort(nums, (a, b) -> {
            int bitA = bitCountMap.get(a);
            int bitB = bitCountMap.get(b);
            if (bitA != bitB) return bitA - bitB;
            return a - b;
        });

        for (int i = 0; i < n; i++) arr[i] = nums[i];
        return arr;
    }
}
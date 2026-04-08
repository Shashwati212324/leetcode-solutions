import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get unique elements (VERY IMPORTANT)
        int[] unique = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            unique[i++] = key;
        }

        // Step 3: QuickSort based on frequency
        quickSort(unique, 0, unique.length - 1, map);

        // Step 4: Take top k
        int[] res = new int[k];
        int index = 0;
        for (int j = unique.length - k; j < unique.length; j++) {
            res[index++] = unique[j];
        }

        return res;
    }

    private void quickSort(int[] arr, int low, int high, HashMap<Integer, Integer> map) {
        if (low >= high) return;

        int s = low, e = high;
        int pivot = map.get(arr[(low + high) / 2]);

        while (s <= e) {
            while (map.get(arr[s]) < pivot) s++;
            while (map.get(arr[e]) > pivot) e--;

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, low, e, map);
        quickSort(arr, s, high, map);
    }
}
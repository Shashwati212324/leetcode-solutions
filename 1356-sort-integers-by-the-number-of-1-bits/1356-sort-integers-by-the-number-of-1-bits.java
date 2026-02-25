class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            int bitA = countOnes(a);
            int bitB = countOnes(b);
            if (bitA != bitB) return bitA - bitB;
            return a - b;
        });

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    private int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
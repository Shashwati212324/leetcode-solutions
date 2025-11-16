class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remaining, int start, 
                           List<Integer> temp, List<List<Integer>> result) {

        // ✔ if sum is over
        if (remaining < 0) return;

        // ✔ valid combination found
        if (remaining == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // ✔ no more numbers allowed
        if (temp.size() == k) return;

        for (int i = start; i <= 9; i++) {
            temp.add(i);                   // choose number i
            backtrack(k, remaining - i, i + 1, temp, result);
            temp.remove(temp.size() - 1);  // backtrack
        }
    }
}

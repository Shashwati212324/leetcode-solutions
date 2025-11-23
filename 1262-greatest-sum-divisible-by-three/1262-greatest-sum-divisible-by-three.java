class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;

        int[] mod1 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] mod2 = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int x : nums) {
            total += x;

            if (x % 3 == 1) {
                if (x < mod1[0]) {
                    mod1[1] = mod1[0];
                    mod1[0] = x;
                } else if (x < mod1[1]) {
                    mod1[1] = x;
                }
            } else if (x % 3 == 2) {
                if (x < mod2[0]) {
                    mod2[1] = mod2[0];
                    mod2[0] = x;
                } else if (x < mod2[1]) {
                    mod2[1] = x;
                }
            }
        }

        if (total % 3 == 0) return total;

        int remove = Integer.MAX_VALUE;

        if (total % 3 == 1) {
            // Option 1: remove smallest mod1 number
            if (mod1[0] != Integer.MAX_VALUE)
                remove = Math.min(remove, mod1[0]);

            // Option 2: remove two smallest mod2 numbers
            if (mod2[1] != Integer.MAX_VALUE)
                remove = Math.min(remove, mod2[0] + mod2[1]);
        } 
        else { // total % 3 == 2

            // Option 1: remove smallest mod2 number
            if (mod2[0] != Integer.MAX_VALUE)
                remove = Math.min(remove, mod2[0]);

            // Option 2: remove two smallest mod1 numbers
            if (mod1[1] != Integer.MAX_VALUE)
                remove = Math.min(remove, mod1[0] + mod1[1]);
        }

        // If no valid removal exists, return 0
        if (remove == Integer.MAX_VALUE) return 0;

        return total - remove;
    }
}

class Solution {
    public int numSteps(String s) {
        // Convert string to char array for easier manipulation
        char[] arr = s.toCharArray();
        int steps = 0;
        int i = arr.length - 1; // start from the least significant bit

        while (i > 0) { // stop when only the first bit remains
            if (arr[i] == '0') {
                // Even: divide by 2 → just move left
                i--;
                steps++;
            } else {
                // Odd: add 1
                steps++;
                // propagate the carry
                int j = i;
                while (j >= 0 && arr[j] == '1') {
                    arr[j] = '0';
                    j--;
                }
                if (j >= 0) {
                    arr[j] = '1';
                } else {
                    // carry goes beyond the first bit → prepend '1'
                    char[] newArr = new char[arr.length + 1];
                    newArr[0] = '1';
                    for (int k = 0; k < arr.length; k++) {
                        newArr[k + 1] = arr[k];
                    }
                    arr = newArr;
                    i++; // adjust index because of new bit
                }
            }
        }

        return steps;
    }
}
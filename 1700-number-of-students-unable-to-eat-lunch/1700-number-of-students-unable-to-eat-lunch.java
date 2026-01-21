class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = new int[2];

        // Count students' preferences
        for (int s : students) {
            count[s]++;
        }

        // Process sandwiches
        for (int s : sandwiches) {
            if (count[s] == 0) {
                break;   // no student wants this sandwich
            }
            count[s]--;
        }

        return count[0] + count[1];
    }
}

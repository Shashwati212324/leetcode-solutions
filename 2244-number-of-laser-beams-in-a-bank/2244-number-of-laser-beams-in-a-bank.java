class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;  // stores number of devices in the last non-empty row
        int totalBeams = 0;
        
        for (String row : bank) {
            int curr = countDevices(row);
            
            // If current row has devices
            if (curr > 0) {
                totalBeams += prev * curr;  // beams = prev_row_devices * current_row_devices
                prev = curr;  // update previous row device count
            }
        }
        
        return totalBeams;
    }

    // Helper method to count '1's in a row
    private int countDevices(String row) {
        int count = 0;
        for (char c : row.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}

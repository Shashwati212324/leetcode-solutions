class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int j = 0; j < queries.length; j++) {
            int cx = queries[j][0];  // center x
            int cy = queries[j][1];  // center y
            int r = queries[j][2];   // radius
            int count = 0;
            
            for (int i = 0; i < points.length; i++) {
                int px = points[i][0];
                int py = points[i][1];
                
                int dx = px - cx;
                int dy = py - cy;
                
                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }
            
            answer[j] = count;
        }
        
        return answer;
    }
}

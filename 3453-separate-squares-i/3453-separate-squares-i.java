class Solution {

    public double separateSquares(int[][] squares) {

        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = 0;

        // Compute total area and search boundaries
        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;

        // Binary search for the minimum y
        for (int i = 0; i < 60; i++) {   // sufficient for 1e-6 precision
            double mid = (low + high) / 2.0;

            if (areaBelow(mid, squares) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Compute total area below horizontal line y = h
    private double areaBelow(double h, int[][] squares) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += l * l;
            } else {
                area += (h - y) * l;
            }
        }

        return area;
    }
}

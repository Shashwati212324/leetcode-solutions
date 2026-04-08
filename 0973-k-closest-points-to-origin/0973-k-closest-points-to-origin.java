class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length - 1);

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void quickSort(int[][] points, int low, int high) {
        if (low >= high) return;

        int s = low, e = high;
        int pivot = distance(points[(low + high) / 2]);

        while (s <= e) {
            while (distance(points[s]) < pivot) s++;
            while (distance(points[e]) > pivot) e--;

            if (s <= e) {
                int[] temp = points[s];
                points[s] = points[e];
                points[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(points, low, e);
        quickSort(points, s, high);
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
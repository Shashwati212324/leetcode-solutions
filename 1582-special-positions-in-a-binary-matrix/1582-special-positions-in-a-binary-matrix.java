class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (checkRow(mat, i, j) && checkCol(mat, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkRow(int[][] mat, int r, int c) {
        for (int j = 0; j < mat[0].length; j++) {
            if (j != c && mat[r][j] == 1) return false;
        }
        return true;
    }

    private boolean checkCol(int[][] mat, int r, int c) {
        for (int i = 0; i < mat.length; i++) {
            if (i != r && mat[i][c] == 1) return false;
        }
        return true;
    }
}
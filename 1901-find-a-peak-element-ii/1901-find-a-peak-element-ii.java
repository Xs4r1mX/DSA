class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = getMaxRowIndex(mat, mid, rows);

            int current = mat[maxRow][mid];
            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < cols - 1) ? mat[maxRow][mid + 1] : -1;

            if (current > left && current > right) {
                return new int[]{maxRow, mid};
            } else if (left > current) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int getMaxRowIndex(int[][] mat, int col, int rows) {
        int maxRow = 0;
        for (int r = 1; r < rows; r++) {
            if (mat[r][col] > mat[maxRow][col]) {
                maxRow = r;
            }
        }
        return maxRow;
    }
}
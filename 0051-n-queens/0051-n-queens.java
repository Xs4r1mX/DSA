import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // For major diagonals (row - col + n - 1)
        boolean[] diag2 = new boolean[2 * n]; // For minor diagonals (row + col)

        backtrack(0, n, board, ans, cols, diag1, diag2);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> ans, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base case: If we've successfully placed queens in all rows
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            // O(1) validation check using tracking arrays
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // 1. Choose (Place Queen)
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // 2. Explore (Move to next row)
            backtrack(row + 1, n, board, ans, cols, diag1, diag2);

            // 3. Un-choose / Backtrack (Remove Queen)
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
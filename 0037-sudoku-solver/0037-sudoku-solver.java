class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // Iterate through each cell on the 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Find an empty cell
                if (board[i][j] == '.') {
                    // Try digits from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place the digit
                            
                            // Recursively try to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }
                            
                            // Backtrack: reset the cell if it doesn't lead to a solution
                            board[i][j] = '.';
                        }
                    }
                    return false; // If no number works for this cell, trigger backtracking
                }
            }
        }
        return true; // All cells are successfully filled
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check the current row
            if (board[row][i] == c) return false;
            
            // Check the current column
            if (board[i][col] == c) return false;
            
            // Check the 3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
            if (board[subgridRow][subgridCol] == c) return false;
        }
        return true;
    }
}
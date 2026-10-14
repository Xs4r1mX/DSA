class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Try starting the word search from every cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (explore(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean explore(char[][] board, String word, int row, int col, int index) {
        // Base case: All characters have been successfully matched
        if (index == word.length()) {
            return true;
        }

        // 1. Check boundary conditions (must use >=)
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // 2. Check if the current cell doesn't match or has already been visited (' ')
        if (board[row][col] != word.charAt(index) || board[row][col] == ' ') {
            return false;
        }

        // Mark current cell as visited
        char val = board[row][col];
        board[row][col] = ' '; 

        // Explore all 4 directions (Left, Right, Up, Down)
        boolean found = explore(board, word, row, col - 1, index + 1) ||
                        explore(board, word, row, col + 1, index + 1) ||
                        explore(board, word, row - 1, col, index + 1) ||
                        explore(board, word, row + 1, col, index + 1);

        // Backtrack: Restore the cell's original value
        board[row][col] = val;
        
        return found;
    }
}
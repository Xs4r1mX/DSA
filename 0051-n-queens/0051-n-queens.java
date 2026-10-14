class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];

        solve(board,0,ans,n);
        System.out.println(ans);
        return ans;
    }

    private void solve(int[][] board, int currentRow, List<List<String>> ans, int n){
        if(n==0){
            addToAnswer(board,ans);
            return;
        }

        for(int j=0;j<board[0].length;j++){
            if(isValid(board,currentRow,j)){
                board[currentRow][j]=1;
                solve(board,currentRow+1,ans,n-1);
                board[currentRow][j]=0;
            }
        }
    }

    private void addToAnswer(int[][] board, List<List<String>> ans) {
        List<String> currentConfiguration = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    rowString.append('Q');
                } else {
                    rowString.append('.');
                }
            }
            currentConfiguration.add(rowString.toString());
        }
        
        ans.add(currentConfiguration);
    }

    private boolean isValid(int[][] board, int currentRow, int currentCol) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. Check Row
        for (int j = 0; j < cols; j++) {
            if (j == currentCol) continue;
            if (board[currentRow][j] == 1) return false;
        }

        // 2. Check Column
        for (int i = 0; i < rows; i++) {
            if (i == currentRow) continue;
            if (board[i][currentCol] == 1) return false;
        }

        // 3. Check Diagonals
        // Top-Left diagonal (Up and Left)
        for (int i = currentRow, j = currentCol; i >= 0 && j >= 0; i--, j--) {
            if (i == currentRow && j == currentCol) continue;
            if (board[i][j] == 1) return false;
        }

        // Top-Right diagonal (Up and Right)
        for (int i = currentRow, j = currentCol; i >= 0 && j < cols; i--, j++) {
            if (i == currentRow && j == currentCol) continue;
            if (board[i][j] == 1) return false;
        }

        // Bottom-Left diagonal (Down and Left)
        for (int i = currentRow, j = currentCol; i < rows && j >= 0; i++, j--) {
            if (i == currentRow && j == currentCol) continue;
            if (board[i][j] == 1) return false;
        }

        // Bottom-Right diagonal (Down and Right)
        for (int i = currentRow, j = currentCol; i < rows && j < cols; i++, j++) {
            if (i == currentRow && j == currentCol) continue;
            if (board[i][j] == 1) return false;
        }

        // If no conflicts found, the position is valid
        return true;
    }
}
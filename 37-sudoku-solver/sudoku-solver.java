class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        // 1. Empty cell dhundo
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // 2. 1 se 9 tak try karo
                    for (char num = '1'; num <= '9'; num++) {

                        // 3. Check karo number valid hai ya nahi
                        if (isValid(board, row, col, num)) {

                            // 4. Number place karo
                            board[row][col] = num;

                            // 5. Aage solve karne ki koshish
                            if (solve(board)) {
                                return true;
                            }

                            // 6. Agar solution nahi mila -> undo
                            board[row][col] = '.';
                        }
                    }

                    // Koi number fit nahi hua
                    return false;
                }
            }
        }

        // Koi empty cell nahi bacha
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        // Row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3 x 3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
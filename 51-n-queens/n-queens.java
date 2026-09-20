class Solution {

    public boolean isSafe(int i, int j, char[][] grid) {
        int n = grid.length; 
        int col = j;

        // top to bottom.
        for (int row = 0; row < i; row++) {
            if (grid[row][col] == 'Q') { 
                return false;
            }
        }

        // negative diagonal
        for (int row = i - 1, c = j - 1; row >= 0 && c >= 0; row--, c--) {
            if (grid[row][c] == 'Q') {
                return false;
            }
        }

        // positive diagonal
        for (int row = i - 1, c = j + 1; row >= 0 && c < n; row--, c++) {
            if (grid[row][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void builder(char[][] grid) {
        for (char[] row : grid) {
            Arrays.fill(row, '.'); 
        }
    }

    public void ustad(char[][] grid, int n, int row, List<List<String>> ans) { 
        if (row == n) {
            // append all data in ans.
            List<String> board = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                board.add(new String(grid[r])); 
                // Converts row directly to String
            }
            ans.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, grid)) { 
                grid[row][col] = 'Q';
                ustad(grid, n, row + 1, ans);
                grid[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        builder(grid);
        ustad(grid, n, 0, ans);

        return ans; 
    }
}
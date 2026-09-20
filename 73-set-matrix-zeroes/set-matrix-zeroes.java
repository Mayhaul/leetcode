class Solution {
    static class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void ustad(int[][] matrix, int i, int j) {
        for (int col = 0; col < matrix[i].length; col++) {
            matrix[i][col] = 0;
        }
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][j] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Pair> originalZeroes = new ArrayList<>();

        // collect all original i, j coordinates of zeroes
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    originalZeroes.add(new Pair(i, j));
                }
            }
        }

        // apply ustad only to the recorded original zeroes
        for (Pair p : originalZeroes) {
            ustad(matrix, p.row, p.col);
        }
    }
}

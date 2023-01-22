class Solution {
    int MIN = Integer.MIN_VALUE%(100003);

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    helper(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == MIN) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void helper(int matrix[][], int row, int col) {
        int i = row, j = col;
        for (j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] != 0) matrix[i][j] = MIN;
        }
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0) matrix[i][col] = MIN;
        }
    }
}


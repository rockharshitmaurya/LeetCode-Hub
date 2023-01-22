class Solution {
    int MIN = Integer.MIN_VALUE%(100003);

//     public void setZeroes(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == 0) {
//                     helper(matrix, i, j);
//                 }
//             }
//         }
        
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == MIN) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }

//     void helper(int matrix[][], int row, int col) {
//         int i = row, j = col;
//         for (j = 0; j < matrix[0].length; j++) {
//             if (matrix[i][j] != 0) matrix[i][j] = MIN;
//         }
//         for (i = 0; i < matrix.length; i++) {
//             if (matrix[i][col] != 0) matrix[i][col] = MIN;
//         }
//     }
    
    public static void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean rowHasZero = false;
    boolean colHasZero = false;

    // check if first row has a zero
    for (int j = 0; j < n; j++) {
        if (matrix[0][j] == 0) {
            rowHasZero = true;
            break;
        }
    }

    // check if first column has a zero
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            colHasZero = true;
            break;
        }
    }

    // mark zeros on first row and column
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // use mark to set elements
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // set first row and column
    if (rowHasZero) {
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }
    if (colHasZero) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
}

}


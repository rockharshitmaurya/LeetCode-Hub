class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        int n = matrix.length, m = matrix[0].length;
        while (matrix[i][j] <= target) {
            int down_i = i + 1, down_j = j;
            if (down_i == n || down_j == m) break;
            if (matrix[i+1][j] > target) break;
            i++;
        }

        while (matrix[i][j] <= target) {
            if (matrix[i][j] == target) return true;
            int left_i = i, left_j = j + 1;
            if (left_i == n || left_j == m) break;
            j++;
        }
        return false;
    }
}
// [[1,3,5,7],
//  [2,11,16,20],
//  [23,30,34,60]]

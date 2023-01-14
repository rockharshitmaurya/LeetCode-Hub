class Solution {
    int dirs[][] = { { 2, 1 }, { 1, 2 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, 2 } };
    double dp[][][];
    public double knightProbability(int n, int k, int row, int column) {
        dp=new double[n+1][n+1][k+1];
        
        for(double arr[][]:dp){
            for(double arr2[]:arr){
                Arrays.fill(arr2,-1);
            }
        }
        return helper(n, row, column, k);
    }

    double helper(int n, int row, int col, int k) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0;
        if (k == 0) return 1.0;
        if(dp[row][col][k]!=-1) return dp[row][col][k];
        double res = 0;

        for (int arr[] : dirs) {
            res += helper(n, row + arr[0], col + arr[1], k - 1);
        }
        return dp[row][col][k]=(res / 8);
    }
}

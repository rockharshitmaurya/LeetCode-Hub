class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans=Integer.MIN_VALUE;
        int n=matrix.length,m=matrix[0].length;
        for(int K=0; K<n; K++){
            int sub[]=new int[m];
            for(int i=K; i<n; i++){
                for(int j=0; j<m; j++){
                    // if(i==0) {
                        // sub[j]=matrix[i][j];
                    // }else{
                        sub[j]+=matrix[i][j];
                    // }
                    
                }
                // System.out.println(Arrays.toString(sub));
                ans=Math.max(ans,maxSumSubArray(sub,k));
            }
        }
        
        return ans;
    }
private int maxSumSubArray(int[] a , int k){

    int max = Integer.MIN_VALUE;
    for(int i=0;i<a.length;i++){
        int tsum = 0;
        for(int j=i;j<a.length;j++){
            tsum += a[j];
            if(tsum <= k) max=Math.max(max,tsum);
        }
    }

    return max;
}
    int findMaxSubarraySum(int arr[], int n, int k) {
        int right = 0;
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            right += arr[i];
            // right - left <= k -> left >= right - k
            Integer left = bst.ceiling(right - k);
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        if (ans == Integer.MIN_VALUE) return Integer.MIN_VALUE; // not found!
        return ans;
    }
}

// class Solution {
//     public int maxSumSubmatrix(int[][] matrix, int k) {
//         int m = matrix.length, n = matrix[0].length;
//         int ans = Integer.MIN_VALUE;
//         for (int r1 = 0; r1 < m; ++r1) {
//             int[] arr = new int[n]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])
//             for (int r2 = r1; r2 < m; ++r2) {
//                 for (int c = 0; c < n; ++c) arr[c] += matrix[r2][c];
                
//                 System.out.println(Arrays.toString(arr));
//                 ans = Math.max(ans, maxSumSubArray(arr, n, k));
//             }
//         }
//         return ans;
//     }
//     int maxSumSubArray(int[] arr, int n, int k) { // O(N * logN)
//         TreeSet<Integer> bst = new TreeSet<>();
//         bst.add(0);
//         int ans = Integer.MIN_VALUE;
//         for (int i = 0, right = 0; i < n; ++i) {
//             right += arr[i];
//             Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k
//             if (left != null) {
//                 ans = Math.max(ans, right - left);
//             }
//             bst.add(right);
//         }
//         return ans;
//     }
// }
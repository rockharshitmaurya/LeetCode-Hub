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
                ans=Math.max(ans,findMaxSubarraySum(sub,m,k));
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
class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = (int) 1e9, count = 0;

        for (int arr[] : matrix) {
            for (int num : arr) {
                if (num < 0) {
                    count++;
                    min = Math.min(min, num * -1);
                    sum += (num * -1);
                } else {
                    sum += num;
                    min = Math.min(min, num);
                }
            }
        }
        
        if(count%2==0) return sum;
        
        
        return sum-(min*2);
    }
}

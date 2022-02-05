class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        label:
        for(int arr[]:matrix){
            for(int a:arr){
                if(a==target) return true;
                else if(a>target) continue label;
            }
        }
        return false;   
    }
}
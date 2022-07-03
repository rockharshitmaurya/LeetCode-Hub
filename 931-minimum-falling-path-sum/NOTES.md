* Recursion
​
```
class Solution {
public int minFallingPathSum(int[][] matrix) {
int ans=Integer.MAX_VALUE;
for(int col=0; col<matrix.length; col++)
ans=Math.min(ans,helper(matrix,0,col));
return ans;
}
int helper(int grid[][],int row,int col){
if(col<0 || col>grid.length-1) return (int)1e9;
if(row==grid.length-1) return grid[row][col];
int left=grid[row][col]+helper(grid,row+1,col-1);
int middle=grid[row][col]+helper(grid,row+1,col);
int right=grid[row][col]+helper(grid,row+1,col+1);
return Math.min(left,Math.min(middle,right));
}
}
```
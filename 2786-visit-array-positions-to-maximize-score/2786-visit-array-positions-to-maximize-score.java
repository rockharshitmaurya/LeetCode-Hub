// class Solution {
//     long dp[][];

//     public long maxScore(int[] nums, int x) {
//         int n = nums.length;
//         dp = new long[n][2];
//         for (long arr[] : dp) {
//             Arrays.fill(arr, -1);
//         }
//         return nums[0] + helper(nums, x, 0, 1);
//     }

//     long helper(int nums[], int x, int last, int idx) {
//         if (idx == nums.length) return 0;

//         long pick = 0, notpick = 0;
        
//         int isOdd=nums[idx] % 2;
        
//         if (dp[last][isOdd] != -1) return dp[last][isOdd];

//         int to_add = nums[idx] - ((nums[idx] % 2 != nums[last] % 2) ? x : 0);

//         pick = to_add + helper(nums, x, idx, idx + 1);
//         notpick = helper(nums, x, last, idx + 1);
//         return dp[last][isOdd] = Math.max(pick, notpick);
//     }
// }
class Solution {
    public long maxScore(int[] nums, int x) {
        int n=nums.length;
        long  dp[][]=new long[n][2];
        for(long p[]:dp)Arrays.fill(p,-1);
        
        return solve(1,nums,x,((nums[0]%2==0)?0:1),nums.length,dp)+nums[0]; //nums[0] is the initial value taken
    }
    public long solve(int i,int nums[],int x,int f,int n,long dp[][]){
        if(i>=n)return 0;
        //storing the parity f of before element
        if(dp[i][f]!=-1)return dp[i][f];
        
        int parity=nums[i]%2;
        long take=0;
        //if parity is same
        if(f==parity){
           take+=nums[i]+solve(i+1,nums,x,parity,n,dp); 
        }
        
        //if parity not same
        else if(f!=parity){
            take+=nums[i]-x+solve(i+1,nums,x,parity,n,dp);
        }
        
        long not=solve(i+1,nums,x,f,n,dp);
        
        return dp[i][f]=Math.max(take,not);
    }
}

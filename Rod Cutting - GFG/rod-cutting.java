// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    int dp[];
    public int cutRod(int price[], int n) {
        dp=new int[n+1];
        // for(int sub[]:dp) 
            Arrays.fill(dp,-1);
        return helper(n-1,price,n);
    }
    int helper(int idx,int price[],int sum){
        if(idx==0){
            return price[0]*(sum/1);
        }
        if(dp[sum]!=-1) return dp[sum];
        int pick=0;
        if((idx+1)<=sum) pick=price[idx]+helper(idx,price,sum-(idx+1));
        int notPick=helper(idx-1,price,sum);
        return dp[sum]=Math.max(pick,notPick);
    }
}
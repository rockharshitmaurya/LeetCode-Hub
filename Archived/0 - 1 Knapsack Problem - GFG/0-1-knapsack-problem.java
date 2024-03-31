// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
      int dp[]=new int[W+1];
      for(int weight=wt[0]; weight<=W; weight++) dp[weight]=val[0];
      
      for(int idx=1; idx<n; idx++){
          for(int w=W; w>=0; w--){
              int take=Integer.MIN_VALUE;
                if(wt[idx]<=w) take=val[idx]+dp[w-wt[idx]];
                int notTake=dp[w];
                dp[w]=Math.max(take,notTake);
          }
      }
      
        return dp[W];
    } 
    static int helper(int idx,int W,int wt[],int val[],int n,int dp[][]){
        if(idx==0) {
            if(wt[0]<=W) return val[0];
            return 0;
        }
        if(dp[idx][W]!=-1) return dp[idx][W];
        int take=0;
        if(wt[idx]<=W) take=val[idx]+helper(idx-1,W-wt[idx],wt,val,n,dp);
        int notTake=helper(idx-1,W,wt,val,n,dp);
        return dp[idx][W]=Math.max(take,notTake);
    }
}



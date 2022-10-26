class Solution {
    int dp[][] = new int[7500][2];
    HashSet<Integer> set = new HashSet<>();

    public int minimumJumps(int[] fbd, int a, int b, int x) {
        for (int arr[] : dp) 
            Arrays.fill(arr, -1);

        for (int num : fbd) 
            set.add(num);

        int res = helper(a, b, x, 0, 1);
        return res >= (int) 1e9 ? -1 : res;
    }

    int helper(int a, int b, int x, int start, int back_move) {
        if (start == x) return 0;

        if (start < 0 || start > 6000 || set.contains(start)) return (int) 1e9;

        if (dp[start][back_move] != -1) {
            return dp[start][back_move];
        }

        
        dp[start][back_move] = 1 + helper(a,b,x,start+a,1);

        if(back_move==1)
        {
            dp[start][back_move] = Math.min(dp[start][back_move],1 +  helper(a,b,x,start-b,0));
        }
      
        return dp[start][back_move];
    }
}

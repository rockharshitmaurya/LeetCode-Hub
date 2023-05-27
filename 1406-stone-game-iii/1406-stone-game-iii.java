class Solution {
    Integer dp[][];
    public String stoneGameIII(int[] stoneValue) {
        dp=new Integer[stoneValue.length][2];
        int hellow=helper(stoneValue,0,true);
        if(hellow<0) return "Bob";
        else if(hellow==0) return "Tie";
        else return "Alice";
        // System.out.println(hellow);
        // return "Alice";
    }

    int helper(int arr[], int idx,boolean turn) {
        if (idx == arr.length) return 0;
        int key=true?1:0;
        if(dp[idx][key]!=null) return dp[idx][key];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = idx; i < Math.min(idx + 3, arr.length); i++) {
            sum += arr[i];
            int res = sum - helper(arr, i + 1,!turn);
            max = Math.max(max, res);
        }

        return dp[idx][key]=max;
    }
}

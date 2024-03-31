class Solution {
    int map[] = new int[10];

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        else if(n==1) return 10;
        int num=(int)Math.pow(10, n);
        return helper(num+ "", 0, 1,0);
    }

    int helper(String num, int idx, int limit, int tsum) {
        
        if (num.length() == idx) {
            // System.out.println(str);
            return 1;
        }

        
        int end = (limit == 1) ? (num.charAt(idx) - '0') : 9;

        int ans = 0;
        for (int dig = 0; dig <= end; dig++) {
            int new_limit = (limit == 1 && dig == end) ? 1 : 0;
            if(map[dig]>0) continue;
            if(tsum+dig>0) map[dig]++;
            ans = ans + helper(num, idx + 1, new_limit, tsum+dig);
            if(tsum+dig>0) map[dig]--;
        }
        
        return ans;
    }
}

class Solution {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum < x) return -1; else if (sum == x) return n;

        int i = n - 1, j = n - 1, ans = n + 1;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && sum + nums[j] > x) {
                sum -= nums[i--];
               if(sum==x) ans = Math.min(ans, i + 1 + (n - (j + 1))); //j+1 because , J has not yet contributed to sum till now
                
            }
            if (sum == x) {
                // System.out.println("INSIDE " + i + " " + j + " " + sum);
                ans = Math.min(ans, i + 1 + (n - (j + 1))); //j+1 because , J has not yet contributed to sum till now
            }
            // System.out.println(i + " " + j + " sum : " + sum);
            sum += nums[j--];
            if (sum == x) {
                // System.out.println("INSIDE " + i + " " + j + " " + sum);
                ans = Math.min(ans, i + 1 + (n - (j + 1)));
            }
        }

        //         int ans = n + 1;

        //         if (sum == x) ans = i;
        //         i--;

        return ans == n + 1 ? -1 : ans;
    }
}


// [1,1,4,2,3]
// 5
// [5,6,7,8,9]
// 4
// [3,2,20,1,1,3]
// 10
// [6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119]
// 31841
// [5,2,3,1,1]
// 5
// [1,1]
// 3
// [5,1,4,2,3]
// 6
// [1,1,99]
// 2
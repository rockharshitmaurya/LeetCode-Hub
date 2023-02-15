class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int rem = 0;

        for (int i = num.length - 1; i >= 0; i--) {
            int digit = k % 10;
            k = k / 10;

            int toadd = (num[i] + digit + rem);

            ans.add(toadd % 10);
            rem = toadd / 10;
        }
        // if (rem != 0) ans.add(rem);
        // System.out.println(k);
        k+=rem;
        while (k > 0) {
            // int digit
            ans.add(k % 10);
            k = k / 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}

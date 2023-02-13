class Solution {

    public int countOdds(int low, int high) {
        int oneToLow = (low + (low % 2)) / 2;
        int TwoToHigh = (high + (high % 2)) / 2;

        // System.out.println(oneToLow + " " + TwoToHigh);

        int ans = TwoToHigh - oneToLow + low % 2;
        return ans;
    }
}
// 1 3 = 3+1/2=2
// 1 7 = 7+1/2=4
// 4=2=2

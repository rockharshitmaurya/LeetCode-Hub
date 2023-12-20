class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int res=money-(prices[0]+prices[1]);
        return res<0?money:res;
    }
}
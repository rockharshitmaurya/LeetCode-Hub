class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= start) continue;
            else start++;
            // 2<=1
        }
        return start;
    }
}

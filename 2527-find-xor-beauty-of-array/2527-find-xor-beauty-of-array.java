class Solution {

    public int xorBeauty(int[] arr) {
        return Arrays.stream(arr).reduce((a, b) -> a ^ b).orElse(0);
    }
}

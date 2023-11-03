class Solution {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= target[target.length - 1]; i++) {
            if (target[idx] != i) {
                ans.add("Push");
                ans.add("Pop");
            } else {
                ans.add("Push");
                idx++;
            }
        }
        return ans;
    }
}

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, n, ans, new TreeSet<>());
        return ans;
    }

    void helper(int k, int n, List<List<Integer>> ans, TreeSet<Integer> ds) {
        if (n < 0 || k < 0) return;
        if (n == 0 && k == 0) {
            ArrayList<Integer> toadd = new ArrayList<>(ds);
            if (ans.contains(toadd)) return;
            ans.add(toadd);
            return;
        }
        for (int val = 1; val <= 9; val++) {
            if (ds.contains(val)) continue;
            ds.add(val);
            helper(k - 1, n - val, ans, ds);
            ds.remove(val);
        }
    }
}

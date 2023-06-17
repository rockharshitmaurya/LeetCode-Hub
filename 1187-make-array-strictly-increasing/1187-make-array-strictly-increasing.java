class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    HashMap<String, Integer> dp = new HashMap<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = helper(arr1, arr2, 0, -1);
        return ans == (int) 1e9 ? -1 : ans;
    }

    int helper(int arr1[], int arr2[], int idx, int ele) {
        if (idx == arr1.length) return 0;
        String key = idx + ":" + ele;
        if (dp.containsKey(key)) return dp.get(key);
        int ans = (int) 1e9;
        if (ele < arr1[idx]) {
            ans = Math.min(ans, helper(arr1, arr2, idx + 1, arr1[idx]));
        }

        Integer high = map.higherKey(ele);
        if (high != null) {
            ans = Math.min(ans, 1 + helper(arr1, arr2, idx + 1, high));
        }
        dp.put(key, ans);
        return ans;
    }
}
// [1,5,3,6,7]
// [4,3,1]
// [1,5,3,6,7]
// [4,5,3,6,7] 1
// [1,5,3,6,7]
// [4,5,3,6,7] 1

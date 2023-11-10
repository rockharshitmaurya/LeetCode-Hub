class Solution {
    // Not Done by me
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (var p: adjacentPairs) {
            int u = p[0];
            int v = p[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        int[] ans = new int[adjacentPairs.length + 1];
        for (var e: map.entrySet()) {
            if (e.getValue().size() == 1) {
                ans[0] = e.getKey(); //get the head of link which has only one child node
                break;
            }
        }
        
        for (int i = 1; i < ans.length; i++) {
            int pre = ans[i - 1];
            for (int curr: map.get(pre)) {
                if (map.containsKey(curr)) {
                    ans[i] = curr;
                    map.remove(pre);
                }
            }
        }
        return ans;
    }
}
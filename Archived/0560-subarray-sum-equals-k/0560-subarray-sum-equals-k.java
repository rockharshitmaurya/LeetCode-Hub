class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, count = 0;

        for (int num : nums) {
            sum = sum + num;
            // System.out.print(sum+" ");
            if (sum == k) count++;

            if (map.containsKey(sum - k)) count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

class Solution {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair<Integer, Integer>> flowers = new ArrayList<>();

        for (int i = 0; i < plantTime.length; i++) {
            flowers.add(new Pair<Integer, Integer>(plantTime[i], growTime[i]));
        }

        Collections.sort(flowers, (a, b) -> (Integer.compare(a.getValue(), b.getValue())));

        int result = 0;
        for (Pair<Integer, Integer> flower : flowers) {
            result = Math.max(result, flower.getValue());
            result += flower.getKey();
        }

        return result;
    }
}
// 10->6

class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> win = new TreeMap<>(), lose = new TreeMap<>();

        for (int arr[] : matches) {
            win.put(arr[0], win.getOrDefault(arr[0], 0) + 1);
            lose.put(arr[1], lose.getOrDefault(arr[1], 0) + 1);
        }
        ArrayList<Integer> all = new ArrayList<>(), one = new ArrayList<>();

        for (int key : win.keySet()) {
            if(!lose.containsKey(key)) all.add(key);
        }
        for (int key : lose.keySet()) {
            if(lose.get(key)==1) one.add(key);
        }

        return List.of(all, one);
    }
}

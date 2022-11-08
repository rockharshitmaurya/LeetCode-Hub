class Solution {
    int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

    public int[] smallestRange(List<List<Integer>> nums) {
        ArrayList<int[]> list = new ArrayList<>();
        int size = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                list.add(new int[] { num, i });
            }
        }
        Collections.sort(list, (o1, o2) -> (o1[0] - o2[0]));
        // for(int arr[]:list) System.out.println(arr[0]+" "+arr[1]);
        int ans[] = { (int) 0, (int) 1e9 };

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> heap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i)[1])) {
                map.put(list.get(i)[1], list.get(i)[0]);
                heap.put(list.get(i)[0],heap.getOrDefault(list.get(i)[0],0)+1);
            }else{
                // heap.put(map.get(list.get(i)[1]),heap.get(map.get(list.get(i)[1]))-1);
                int key=map.get(list.get(i)[1]);
                heap.put(key,heap.get(key)-1);
                if(heap.get(key)==0) heap.remove(key);
                // heap.remove(map.get(list.get(i)[1]));
                map.put(list.get(i)[1], list.get(i)[0]);
                // heap.put(list.get(i)[0],1);
                heap.put(list.get(i)[0],heap.getOrDefault(list.get(i)[0],0)+1);
            }
            if (map.size() == size) {
                // System.out.println(heap);
                if(heap.lastKey()-heap.firstKey()<ans[1]-ans[0]){
                    ans[0]=heap.firstKey();
                    ans[1]=list.get(i)[0];
                }
                // System.out.println(ans[0]+"---"+ans[1]);
                
            }
        }
        return ans;
    }
}
// [[1,69,89,90,98],[73,94,94,96],[11,13,76,79,90]]
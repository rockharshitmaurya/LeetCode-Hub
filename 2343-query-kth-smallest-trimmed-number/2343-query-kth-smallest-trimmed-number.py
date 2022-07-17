class Solution {
public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    HashMap<Integer, Node[]> map = new HashMap<>();
    int[] res = new int[queries.length];
    int idx = 0;
    for(int[] query : queries){
        if(!map.containsKey(query[1])){  // make and store array if not already made.
            Node[] arr = new Node[nums.length];
            for(int i=0; i<nums.length; i++){
                String x = nums[i].substring(nums[i].length()-query[1], nums[i].length()); // trim as required
                int start = 0;
                while(start!=x.length() && x.charAt(start)==0) start++; // remove leading zeroes
                x.substring(start, x.length());
                arr[i] = new Node(i, x);
            }
            Arrays.sort(arr, (a, b)-> (a.val.compareTo(b.val)));
            map.put(query[1], arr);
        }
        res[idx++] = map.get(query[1])[query[0]-1].index; // get required value.
    }
    return res;
}

class Node{ int index; String val;  // custom object to store both index and value.
    Node(int i, String v){ this.index = i; this.val = v; } }

}
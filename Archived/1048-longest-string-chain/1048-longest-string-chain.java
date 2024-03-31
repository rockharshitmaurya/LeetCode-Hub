class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (o1, o2) -> (o1.length() - o2.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int ans=0;
        for (String str : words) {
            int val = 0;
            for (int i = 0; i < str.length(); i++) {
                String new_string = str.substring(0, i) + str.substring(i + 1);
                if (map.containsKey(new_string)) {
                    val = Math.max(val, map.get(new_string));
                }
            }
            map.put(str, val + 1);
            ans=Math.max(ans,val+1);
        }

        // System.out.println(Arrays.toString(words));
        return ans;
    }
}
// [abc,bcd,acd,abcd]

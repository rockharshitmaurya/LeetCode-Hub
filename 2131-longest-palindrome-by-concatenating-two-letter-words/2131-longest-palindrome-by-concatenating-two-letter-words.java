class Solution {

    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> set = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (set.containsKey(rev)) {
                set.put(rev,set.get(rev)-1);
                if(set.get(rev)==0) set.remove(rev);
                // System.out.println(word + " " + rev);
                ans += 4;
            } else {
                set.put(word,set.getOrDefault(word,0)+1);
            }
        }
        // System.out.println(set);
        for (String word : set.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}
// of qf  fq fo

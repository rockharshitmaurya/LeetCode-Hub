class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        backtrack(s, words, new StringBuilder(), res, 0);
        return res;
    }

    private static void backtrack(String s, Set<String> words, StringBuilder currentSentence, List<String> res, int i) {
        if (i == s.length()) {
            res.add(currentSentence.toString().trim());
            return;
        }

        for (int j = i+1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (words.contains(word)) {
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                backtrack(s, words, currentSentence, res, j);
                currentSentence.setLength(currentLength);
            }
        }
    }
}
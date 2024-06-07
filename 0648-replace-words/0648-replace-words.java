class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashMap<Character, ArrayList<String>> newDict = new HashMap<>();

        for(String word: dictionary){
            char c = word.charAt(0);
            newDict.putIfAbsent(c, new ArrayList<String>());
            newDict.get(c).add(word);
        }

        List<String> wordSplit = Arrays.asList(sentence.split(" "));

        for (int i = 0; i < wordSplit.size(); i++) {
            String word = wordSplit.get(i);
            List<String> list = newDict.getOrDefault(word.charAt(0), new ArrayList<>());
            for (String prefix : list) {
                if (wordSplit.get(i).startsWith(prefix)) {
                    wordSplit.set(i, prefix);
                }
            }
        }

        return String.join(" ", wordSplit);
    }
}
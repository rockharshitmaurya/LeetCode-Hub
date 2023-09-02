class Solution {
    public int minExtraChar(String s, String[] dictionary) {

            return substring_dfs(s,  new HashSet<>(Arrays.asList(dictionary)),  new HashMap<>());
    }
    private int substring_dfs(String given_string, Set<String> given_strings, Map<String, Integer> dynamic) {
    if (given_string.length() == 0) {
        return 0;
    }
    if (dynamic.containsKey(given_string)) {
        return dynamic.get(given_string);
    }
    int minExtra = given_string.length();
    for (int i = 1; i <= given_string.length(); i++) {
        String left = given_string.substring(0, i);
        if (given_strings.contains(left)) {
            minExtra = Math.min(minExtra, substring_dfs(given_string.substring(i), given_strings, dynamic));
        }
    }
    minExtra = Math.min(minExtra, 1 + substring_dfs(given_string.substring(1), given_strings, dynamic));
    dynamic.put(given_string, minExtra);
    return minExtra;
}
}
class Solution {

    public String minimumString(String a, String b, String c) {
        String[] strings = { a, b, c };
        String minString = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    for (int k = 0; k < 3; k++) {
                        if (k != i && k != j) {
                            String mergedString = mergeStrings(mergeStrings(strings[i], strings[j]), strings[k]);
                            if (minString.equals("") || mergedString.length() < minString.length() || (mergedString.length() == minString.length() && mergedString.compareTo(minString) < 0)) {
                                minString = mergedString;
                            }
                        }
                    }
                }
            }
        }
        return minString;
    }

    String mergeStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 >= len2 && str1.contains(str2)) return str1;

        int commonLen = Math.min(len1, len2);
        while (commonLen > 0 && !str1.endsWith(str2.substring(0, commonLen))) {
            commonLen--;
        }
        String mergedString = str1 + str2.substring(commonLen);
        return mergedString;
    }
}

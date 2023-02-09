class Solution {

    public long distinctNames(String[] ideas) {
        List<String> arr[] = new ArrayList[26]; // create array of ArrayList
        long disName = 0; // Instead ArrayList, HashSet can be used
        for (
            int i = 0;
            i < 26;
            i++
        ) arr[i] = new ArrayList<>(); // assign new ArrayList to each index

        for (String s : ideas) arr[s.charAt(0) - 'a'].add(s.substring(1)); // store each string A/C to its 1st char

        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                Set<String> set = new HashSet<>(); // store all strings of arr[i] & arr[j]

                set.addAll(arr[i]);
                set.addAll(arr[j]);
                disName += (arr[i].size() - set.size()) * (arr[j].size() - set.size()); // no. of pairs possible
            }
        }

        return disName * 2;
    }
}

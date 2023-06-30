class Solution {

    
    int dp[][][];
    public int minimizeConcatenatedLength(String[] words) {
        int n = words[0].length();
        dp=new int[26][26][1001];
        for(int arr2[][]:dp){
            for(int arr[]:arr2){
                Arrays.fill(arr,-1);
            }
        }
        return n+helper(words[0].charAt(0), words[0].charAt(n - 1), 1, words);
    }

    int helper(char first, char last,int idx, String words[]) {
        if (words.length == idx) return 0;

        if(dp[first-'a'][last-'a'][idx]!=-1) return dp[first-'a'][last-'a'][idx];

        String word = words[idx];
        int size = word.length();

        int new_len = (last == word.charAt(0)) ?  - 1 : 0;

        int aPlusb = size+new_len+helper(first, word.charAt(size - 1), idx + 1, words);

        new_len = (first == word.charAt(size - 1)) ? - 1 : 0;

        int bPlusa = size+new_len+helper(word.charAt(0), last, idx + 1, words);

        return dp[first-'a'][last-'a'][idx]=Math.min(aPlusb, bPlusa);
    }
}
// abc-->arr[i]
// arr[0]--->abc

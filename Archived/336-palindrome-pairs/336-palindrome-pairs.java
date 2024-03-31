class Solution {
    //coded by me: TLE for last test case
//     public List<List<Integer>> palindromePairs(String[] words) {
//         List<List<Integer>> ans=new ArrayList<>();
//         HashMap<String,Integer> map=new HashMap<>();
//         for(int i=0; i<words.length; i++){
//             map.put(words[i],i);
//         }
        
//         for(int i=0; i<words.length; i++){
//             for(int j=0; j<=words[i].length(); j++){
//                 String str1=words[i].substring(0,j);
//                 String str2=words[i].substring(j);
                
//                 if(isPalindrom(str1)){
//                     String str2rev=new StringBuilder(str2).reverse().toString();
//                     if(map.containsKey(str2rev) && map.get(str2rev)!=i){
//                         ans.add(new ArrayList<>(Arrays.asList(map.get(str2rev),i)));
//                     }
//                 }
                
//                 if(str2.length()!=0 && isPalindrom(str2)){
//                     String str1rev=new StringBuilder(str1).reverse().toString();
//                     if(map.containsKey(str1rev) && map.get(str1rev)!=i){                        
//                         ans.add(new ArrayList<>(Arrays.asList(i,map.get(str1rev))));
//                     }
//                 }
//             }
//         }
        
//         return ans;
//     }
    
//     boolean isPalindrom(String str){
//         for(int i=0; i*2<str.length(); i++){
//             if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
//         }
//         return true;
//     }
    
    private static class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;
    	
    TrieNode() {
    	next = new TrieNode[26];
    	index = -1;
    	list = new ArrayList<>();
    }
}
    
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();

    TrieNode root = new TrieNode();
		
    for (int i = 0; i < words.length; i++) {
        addWord(root, words[i], i);
    }
		
    for (int i = 0; i < words.length; i++) {
        search(words, i, root, res);
    }
    
    return res;
}
    
private void addWord(TrieNode root, String word, int index) {
    for (int i = word.length() - 1; i >= 0; i--) {
        int j = word.charAt(i) - 'a';
				
        if (root.next[j] == null) {
            root.next[j] = new TrieNode();
        }
				
        if (isPalindrome(word, 0, i)) {
            root.list.add(index);
        }
				
        root = root.next[j];
    }
    	
    root.list.add(index);
    root.index = index;
}
    
private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
    for (int j = 0; j < words[i].length(); j++) {	
    	if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
    	    res.add(Arrays.asList(i, root.index));
    	}
    		
    	root = root.next[words[i].charAt(j) - 'a'];
      	if (root == null) return;
    }
    	
    for (int j : root.list) {
    	if (i == j) continue;
    	res.add(Arrays.asList(i, j));
    }
}
    
private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
    	if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    	
    return true;
}
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        ArrayList<Character> arr=new ArrayList<>();
        for(char c:t.toCharArray()){
                arr.add(c);
        }
        int i=0,len=s.length();
        for(char c:t.toCharArray()){
            if(i>=len) break;   
            if(i<len &&  c!=s.charAt(i)) arr.remove(new Character(c));
            else i++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }
        // System.out.println(arr);
        if(arr.size()<len) return false;
        return sb.toString().substring(0,len).equals(s);
        // return true;
    }
}

// "acb"
// "ahbgdc"
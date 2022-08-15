class Solution {
    HashSet<Character> set;
    String res="";
    public String smallestNumber(String s) { 
        set=new HashSet<>();
        
        if(!s.contains("I")){
            for(int i=s.length()+1; i>=1; i--) res+=i;
            return res;
        } 
        helper(s,0,"");
    return res;
    }
    boolean helper(String pattern,int idx,String ans){
        if((ans.length()-1)==pattern.length()){
            if(isValid(pattern,ans)){
                res=ans;
                return true;
            } 
            return false;
        }
        for(int i=idx; i<=pattern.length(); i++){
            for(Character j='1'; j<='9'; j++){
                if(set.contains(j)) continue;
                set.add(j);
                if(ans.length()<=1 || isValid(pattern,ans)) {
                    if(helper(pattern,i+1,ans+j)) return true;
                }
                set.remove(j);
            }
        }
        return false;
    }
    boolean isValid(String pattern,String find){
        boolean flag=true;
        // System.out.println(find);
        for(int i=0; i<Math.min(pattern.length(),find.length()-1); i++){
                if(pattern.charAt(i)=='I'){
                    if(find.charAt(i)>find.charAt(i+1)) return false;
                }else{
                    if(find.charAt(i)<find.charAt(i+1)) return false;
                }
        }
        return flag;
    }
}
class Solution {
    public int myAtoi(String s) {
        StringBuilder sb=new StringBuilder(),sb_2=new StringBuilder();
        s=s.trim();
        boolean flag=false;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
           if(isValid(i,ch) || Character.isDigit(ch)){
                 if(ch>'0') flag=true;
                 if(isValid(i,ch) || flag) sb_2.append(ch); 
           } 
            else break;
        }  
        if(sb_2.length()==1 && !Character.isDigit(sb_2.charAt(0)) || sb_2.length()==0) return 0;
        // if(sb_2.length()==0) return 0;
        if(sb_2.length()>12){
            sb_2.setLength(12);
        }
        
        s=sb_2.toString();
        long num=Long.parseLong(s);
        if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)num;
    }
    
    boolean isValid(int i,char ch){
        return ((i==0) && (ch=='-' || ch=='+')); 
    }
}
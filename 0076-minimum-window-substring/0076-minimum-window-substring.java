class Solution {
    public String minWindow(String s, String t) {
        
        int t_hash[]=new int[256],s_hash[]=new int[256];
        
        int n=s.length(), st=0,end=n;
        int target=t.length(); 
        for(char ch:t.toCharArray()){
            t_hash[ch]++;
        }
        
        int i=0,j=0;
        boolean flag=false;
        while(i<n && j<n){
            char ch=s.charAt(j);
            
            s_hash[ch]++;
            
            if(s_hash[ch]<=t_hash[ch] && t_hash[ch]!=0 && target!=0) target-=1;
            
            
            
            
            
            while(i<j && (t_hash[s.charAt(i)]==0 || (s_hash[s.charAt(i)]>t_hash[s.charAt(i)]))){
                System.out.println(i+" INSIDE "+j);
                s_hash[s.charAt(i)]--; i++;
            }
            System.out.println(i+" ---INSIDE "+j);
            if(target==0){
                flag=true;
                if(j-i < end-st){
                    st=i; end=j;
                    // System.out.println(i+" IN_INSIDE "+j);
                }
            }
            
            j++;
        }
        if(!flag) return "";
        return s.substring(st,end+1);
    }
}
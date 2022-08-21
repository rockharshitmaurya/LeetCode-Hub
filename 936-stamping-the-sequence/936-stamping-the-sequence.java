class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char S[]=stamp.toCharArray();
        char T[]=target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean vis[]=new boolean[T.length];
        int stars=0;
        
        while(stars<T.length){
            boolean doneReplace=false;
            
            for(int i=0; i<=T.length-S.length; i++){
                
                if(!vis[i] && canReplace(S,T,i)){
                    stars=replace(T,i,S.length,stars);
                    doneReplace=true;
                    vis[i]=true;
                    res.add(i);
                    if(stars==T.length) break;
                }
            }
            
            if(!doneReplace) return new int[0];
        }
        int arr[]=new int[res.size()];
        
        for(int i=0; i<arr.length; i++){
            arr[i]=res.get(res.size()-i-1);
        }
        return arr;
    }
    
    boolean canReplace(char S[],char T[],int P){
        for(int i=0; i<S.length; i++){
            if(T[i+P]!='*' && T[i+P]!=S[i]) return false;
        }
        return true;
    }
    
    int replace(char T[],int p,int n,int stars){
        
        for(int i=0; i<n; i++){
            if(T[i+p]!='*'){
                T[i+p]='*';
                stars++;
            }
        }
        return stars;
    }
    
    
}
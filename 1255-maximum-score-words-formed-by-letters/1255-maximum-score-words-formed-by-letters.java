class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int cur_letters[]=new int[26];
        for(char ch:letters){
            cur_letters[ch-'a']++;
        }
        
        
        return helper(words,cur_letters,score,0);
    }
    
    int helper(String words[],int[] letters,int score[],int idx){
        if(idx==words.length) return 0;
        int make=0,notmake=0;
        
        int strHash[]=hash(words[idx]);
        int letters_copy[]=letters.clone();
        int score_copy[]=score.clone();
        // System.out.println(Arrays.toString(strHash));
        // System.out.println(Arrays.toString(letters_copy));
        if(isPossible(strHash,letters)){
            make=getScore(strHash,letters,score)+helper(words,letters.clone(),score,idx+1);
            
            // System.out.println(make);
        }
        notmake=helper(words,letters_copy,score_copy,idx+1);
        return Math.max(make,notmake);
    }
    
    int getScore(int str[],int available[],int score[]){
        int sum=0;
        for(int i=0; i<26; i++){
            if(str[i]==0) continue;
            
            int count=str[i];
            
            sum+=(score[i]*count);
            
            available[i]-=count;
        }
        return sum;
    }
    
    int[] hash(String str){
        int count[]=new int[26];
        for(char ch:str.toCharArray()){
            count[ch-'a']++;
        }
        
        return count;
    }
    
    boolean isPossible(int str[],int available[]){
        for(int i=0; i<26; i++){
            if(str[i]>available[i]) return false;   
        }
        return true;
    }
}
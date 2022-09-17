class Solution {
    public int countDaysTogether(String al_a, String al_l, String b_a, String b_l) {
        
        int al_arr=daysConvert(Integer.parseInt(al_a.split("-")[0]))+Integer.parseInt(al_a.split("-")[1]);
        int al_end=daysConvert(Integer.parseInt(al_l.split("-")[0]))+Integer.parseInt(al_l.split("-")[1]);
                                                                                      
        int bob_arr=daysConvert(Integer.parseInt(b_a.split("-")[0]))+Integer.parseInt(b_a.split("-")[1]);
        int bob_end=daysConvert(Integer.parseInt(b_l.split("-")[0]))+Integer.parseInt(b_l.split("-")[1]);
        
        
        int line[]=new int[370];
                                                                                      
        int ans=0,sum=0;
        
        line[al_arr]++;
        line[al_end+1]--;
        line[bob_arr]++;
        line[bob_end+1]--;
        
        for(int num:line){
            sum+=num;
            if(sum==2) ans++;
        }
                                                                                      
        return ans;
        
    }
    
    int daysConvert(int num){
        int days[]={0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day=0;
        for(int i=1; i<=num-1; i++){
            day+=days[i];
        }
        return day;
    }
}
class Solution {
    HashMap<Character,Integer> map=new HashMap<>();

    public int romanToInt(String s) {
        map.put('I',1);     map.put('V',5);     map.put('X',10);     map.put('L',50);     map.put('C',100);     map.put('D',500);     map.put('M',1000);
        int ans=0,i=s.length()-1;
        for(; i>0; i--){
            int add=0;
            if(map.get(s.charAt(i-1))<map.get(s.charAt(i))){
                add=map.get(s.charAt(i))-map.get(s.charAt(i-1)); i--;
            }else{
                add=map.get(s.charAt(i));
            }
            ans+=add;
            // System.out.println(ans);
        }
        if(i==0) ans+=map.get(s.charAt(i));
        return ans;
    }
}
class Solution {
    int mask_3=224,mask_4=240;
    public boolean validUtf8(int[] data) {
        
        
        int noOfBytes=0;
        
        for(int i=0; i<data.length; i++){
            
          if(oneByte(data[i])){
              noOfBytes=1;
          }else if(twoByte(data[i])){
              // System.out.println(i);
              noOfBytes=2;
          }else if(threeByte(data[i])){
              noOfBytes=3;
          }else if(fourByte(data[i])){
              noOfBytes=4;
          }else{
              return false;
          }
           for(int j=1; j<noOfBytes; j++){
               if(i+j>=data.length) return false;
               if(!isRest(data[i+j])) return false;
           }
            i+=(noOfBytes-1);
        }
        return true;  
    }
    boolean oneByte(int num){
        return isSet(num,8)==false;
    }
    boolean twoByte(int num){
     if(isSet(num,8) && isSet(num,7) && isSet(num,6)==false) return true;
        else return false;
    }
    
    boolean threeByte(int num){
     if(isSet(num,8) && isSet(num,7) && isSet(num,6) && isSet(num,5)==false){
         return true;
     }
      return false;
    }
    
    boolean isRest(int num){
        if(isSet(num,8) && isSet(num,7)==false) return true;
        return false;
    }
    
    boolean fourByte(int num){
     if(isSet(num,8) && isSet(num,7) && isSet(num,6) &&  isSet(num,5) && isSet(num,4)==false){
         return true;
     }
      return false;
    }
    
    public  boolean isSet(int n, int k)
    {
        if ((n & (1 << (k - 1))) > 0)
            return true;
        else
            return false;
    }
}
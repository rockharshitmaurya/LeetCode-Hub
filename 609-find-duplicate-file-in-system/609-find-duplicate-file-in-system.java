class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String str: paths){
            String arr[]=str.split(" ");
            // System.out.println(arr[0]);
            for(int i=1; i<arr.length; i++){
                String sub_str=arr[i];
                String sub_arr[]=sub_str.split("\\(");
                // System.out.println(sub_arr[0]+" "+sub_arr[1]);
                if(!map.containsKey(sub_arr[1])){
                    map.put(sub_arr[1],new ArrayList<>());
                }
                
                map.get(sub_arr[1]).add(arr[0]+"/"+sub_arr[0]);
            }
        }
        
        for(ArrayList<String> list:map.values()){
            if(list.size()>1){
                ans.add(list);
            }
        }
        
        return ans;
    }
}
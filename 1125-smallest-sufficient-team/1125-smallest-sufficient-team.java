class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        dp=new HashMap<>();

        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<req_skills.length;i++) {
            map.put(req_skills[i], i);
        }

        Set<Integer> ret=util(map, people, new boolean[req_skills.length]);
        int ans[]=new int[ret.size()];
        int i=0;
        for(int x: ret) {
            ans[i++]=x;
        }
        return ans;
    }
    
    private Map<String, Set<Integer>> dp;

    private Set<Integer> util(Map<String, Integer> map, List<List<String>> people, boolean gotSkill[]) {
        //terminting condition
        boolean gotAll=true;
        for(boolean skill: gotSkill) {
            if(!skill) {
                gotAll=false;
                break;
            }
        }
        if(gotAll) return new HashSet<>();

        String key=Arrays.toString(gotSkill);  //for dp
        if(dp.containsKey(key)) return dp.get(key);

        //main code
        Set<Integer> ans=null;
        int minLength=Integer.MAX_VALUE;

        boolean temp[]=gotSkill.clone();

        for(int i=0; i<people.size(); i++) {
            gotSkill=temp.clone();
            
            for(String skill: people.get(i)) {
                gotSkill[map.get(skill)]=true;
            }

            boolean anyNew=false;
            for(int j=0; j<temp.length; j++) {
                if(temp[j]!=gotSkill[j]) {
                    anyNew=true;
                    break;
                }
            }

            if(anyNew) { //avoid repetition
                Set<Integer> ret=new HashSet<>(util(map, people, gotSkill));
                ret.add(i);

               /* For each person, for each set of skills, we can
                    update our understanding of a minimum set of people needed to
                        perform this set of skills. */
                if(ret.size()<minLength) {
                    minLength=ret.size();
                    ans=ret;
                }
            }
        }

        dp.put(key, ans);
        return ans;
    }
}
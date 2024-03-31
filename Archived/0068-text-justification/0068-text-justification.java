class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        Queue<String> q = new LinkedList<>();
        int index = 0, len = words.length;
        int count = 0;
        List<String> ans = new ArrayList<>();
        while (index < len) {
            while (index < len && count + words[index].length() + q.size() <= maxWidth) {
                q.offer(words[index]);
                count += words[index].length();
                index++;
            }

            int div = ((q.size() - 1) == 0 ? 1 : (q.size() - 1));
            int space = (maxWidth - count) / div;
            int extra = (maxWidth - count) % div;
            StringBuilder sb = new StringBuilder();
            // System.out.println(q+" "+space);
            

            if (q.size() == 1) {
                sb.append(q.poll());
                sb.append(" ".repeat(space));
            } else {
                while (q.size() > 1) {
                    sb.append(q.poll());
                    int toadd=0;
                    if(extra!=0){
                        toadd=1;
                        extra-=1;
                    }
                    sb.append(" ".repeat(space+toadd));
                }
                sb.append(q.poll());
            }
            ans.add(sb.toString());
            // q.clear();
            count = 0;
        }
        
        
        ans.set(ans.size()-1,lastLine(ans.get(ans.size()-1),maxWidth));
        
        // System.out.println("______________________________________________");

        return ans;
    }
    
    String lastLine(String str,int max){
        String main=String.join(" ",str.split("\\s+"));
        int space=max-main.length();
        return main+" ".repeat(space);
    }
}

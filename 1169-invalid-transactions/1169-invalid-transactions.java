class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String, List<Node>> map=new HashMap<>();
        boolean[] invalid=new boolean[transactions.length];
        for(int i=0;i<transactions.length;i++) {
            String[] cur=transactions[i].split(",");
            if(!map.containsKey(cur[0])) map.put(cur[0], new ArrayList<>());
            map.get(cur[0]).add(new Node(cur[1], cur[2], cur[3], i));
        }
        for(List<Node> l : map.values()) {
            Collections.sort(l, new Comparator<Node>() {
                public int compare(Node a, Node b) {
                    return a.time-b.time;
                }
            });
            for(int i=0;i<l.size();i++) {
                for(int j=i+1;j<l.size()&&l.get(j).time<=l.get(i).time+60;j++) {
                    if(!l.get(i).city.equals(l.get(j).city)) {
                        invalid[l.get(i).index]=true;
                        invalid[l.get(j).index]=true;
                    } 
                }
                if(l.get(i).amount>1000) invalid[l.get(i).index]=true;
            }
        }
        List<String> res=new ArrayList<>();
        for(int i=0;i<invalid.length;i++) {
            if(invalid[i]) res.add(transactions[i]);
        }
        return res;
    }

public class Node {
    int time;
    int amount;
    String city;
    int index;
    Node(String time, String amount, String city, int index) {
        this.time=Integer.parseInt(time);
        this.amount=Integer.parseInt(amount);
        this.city=city;
        this.index=index;
    }
}
}
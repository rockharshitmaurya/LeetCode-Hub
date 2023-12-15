class Solution {

    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for (List<String> list : paths) {
            set.add(list.get(0));
        }
        // System.out.println(set);
        for (List<String> list : paths) {
            if (!set.contains(list.get(1))) return list.get(1);
            else if(!set.contains(list.get(0))) return list.get(0);
        }

        return "";
    }
}

class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] sup) {
        List<String> ans = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();

        for (String str : sup) set.add(str);
        boolean flag = true;

        while (flag) {
            flag ^= flag;
            outer:for (int i = 0; i < recipes.length; i++) {
                if (seen.contains(i)) continue;
                String food = recipes[i];

                for (String ind : ingredients.get(i)) {
                    if (!set.contains(ind)) continue outer;
                }
                ans.add(food);
                set.add(food);
                seen.add(i);
                flag = true;
            }
        }

        return ans;
    }
}

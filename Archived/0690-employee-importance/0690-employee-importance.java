/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, i);
        }
        // System.out.println(map);
        return helper(id,employees);
    }

    int helper(int root, List<Employee> employees) {
        if (!set.add(root)) return 0;

        int sum = employees.get(map.get(root)).importance;
        for (int child : employees.get(map.get(root)).subordinates) {
            sum += helper(child, employees);
        }

        return sum;
    }
}

import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) {
            return -1;
        }
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String currentCombination = current.getKey();
            int moves = current.getValue();
            
            if (currentCombination.equals(target)) {
                return moves;
            }
            
            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newDigit = (currentCombination.charAt(i) - '0' + delta + 10) % 10;
                    String newCombination = currentCombination.substring(0, i) +
                                             newDigit +
                                             currentCombination.substring(i + 1);
                    
                    if (!visited.contains(newCombination) && !deadendSet.contains(newCombination)) {
                        visited.add(newCombination);
                        queue.offer(new Pair<>(newCombination, moves + 1));
                    }
                }
            }
        }
        
        return -1; // Target is not reachable
    }
}


// class Solution {
//     HashSet<String> set;

//     public int openLock(String[] deadends, String target) {
//         set = new HashSet<>();
//         for (String str : deadends) {
//             set.add(str);
//         }

//         return helper("", target, 0);
//     }

//     int helper(String node, String target, int step) {
//         System.out.println(node);
        
//         if (node.equals(target)) {
//             return step;
//         }
//         else if (set.contains(node)) {
//             return Integer.MAX_VALUE;
//         }else if (node.length() == 4) {
//             set.add(node);
//             return Integer.MAX_VALUE;
//         }

        
//         int min = Integer.MAX_VALUE;

//         for (char digit = '0'; digit <= '9'; digit++) {
//             min = Math.min(min, helper(node + digit, target, step + 1));
//         }

//         for (char digit = '9'; digit >= '0'; digit--) {
//             min = Math.min(min, helper(node + digit, target, step + 1));
//         }

//         return min;
//     }

//     StringBuilder next(StringBuilder str, int i) {
//         int num = str.charAt(i) - '0';
//         num = (num + 1) % 10;
//         str.setCharAt(i, (char) (num + '0'));
//         return str;
//     }

//     StringBuilder prev(StringBuilder str, int i) {
//         int num = str.charAt(i) - '0';
//         if (num == 0) {
//             num = 9;
//         } else {
//             num--;
//         }
//         str.setCharAt(i, (char) (num + '0'));
//         return str;
//     }
// }

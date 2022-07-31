the time complexity is actually O(n) only.
Because map[index] = -1;(set all visited node to -1) line run after a path is all completed, mean already find a cycle or the tail.
​
In next for loop, line if (map[index] == -1) return = -1; will check if that path have visited, mean all node will only visited once.
class Solution:
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        if min_sum > len(num2) * 9:
            return 0
        if min_sum == 1 and max_sum > len(num2) * 9:
            return (int(num2) - int(num1) + 1) % int(1e9 + 7)
        s = 0
        for i in range(int(num1), int(num2) + 1):
            if min_sum <= sum(map(int, str(i))) <= max_sum:
                s += 1
        return s % int(1e9 + 7)
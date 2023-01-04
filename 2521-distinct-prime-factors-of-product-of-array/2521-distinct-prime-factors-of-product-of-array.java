class Solution {

    public int distinctPrimeFactors(int[] nums) {
        int max = 0;

        for (int ele : nums) {
            max = Math.max(max, ele);
        }
        List<Integer> primes = allPrimes(max);

        int ans = 0;

        for (int prime : primes) {
            boolean flag = false;
            
            for (int num : nums) {
                while (num % prime == 0) {
                    num /= prime;
                    flag = true;
                }
            }

            if (flag) ans++;
        }

        return ans;
    }

    public List<Integer> allPrimes(int n) {
        boolean[] notP = _allPrimes(n);
        List<Integer> res = new ArrayList<>();
        for (int x = 2; x <= n; x++) if (!notP[x]) res.add(x);
        return res;
    }

    private boolean[] _allPrimes(int n) {
        boolean[] notP = new boolean[n + 1];
        for (int x = 4; x <= n; x++) for (int y = 2; y * y <= x; y++) if (!notP[y] && x % y == 0) {
            notP[x] = true;
            break;
        }

        return notP;
    }
}

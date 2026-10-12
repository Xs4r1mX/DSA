class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        // Even indices have 5 choices; odd indices have 4 choices
        long even = (n + 1) / 2;
        long odd = n / 2;

        // Total combinations = 5^even * 4^odd
        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int) ((evenWays * oddWays) % MOD);
    }

    // Iterative Binary Exponentiation
    private long power(long x, long n) {
        long result = 1;

        while (n > 0) {

            // If exponent is odd, multiply result by current base
            if (n % 2 == 1) {
                result = (result * x) % MOD;
            }

            // Square the base and apply modulo
            x = (x * x) % MOD;

            // Halve the exponent
            n /= 2;
        }

        return result;
    }
}
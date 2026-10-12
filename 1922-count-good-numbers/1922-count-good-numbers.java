class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        // Even indices have 5 choices: 0, 2, 4, 6, 8
        // Odd indices have 4 choices: 2, 3, 5, 7
        long even = (n + 1) / 2;
        long odd = n / 2;

        // Total combinations = 5^(even positions) * 4^(odd positions)
        // Use modulo to prevent numbers from becoming too large
        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int) ((evenWays * oddWays) % MOD);
    }

    // Calculates (x^n) % MOD using Binary Exponentiation
    private long power(long x, long n) {
        long result = 1;

        while (n > 0) {

            // If exponent is odd, multiply result by current base
            if (n % 2 == 1) {
                result = (result * x) % MOD;
            }

            // Square the base for the next iteration
            x = (x * x) % MOD;

            // Halve the exponent
            n /= 2;
        }

        return result;
    }
}
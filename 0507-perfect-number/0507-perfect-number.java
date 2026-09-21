class Solution {
    public boolean checkPerfectNumber(int num) {
        // Numbers <= 1 are not perfect numbers
        if (num <= 1) {
            return false;
        }

        // Start total with 1 since 1 is always a proper divisor
        int total = 1;

        // Loop up to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                total += i;
                
                // Add paired divisor if it's not a duplicate (e.g., perfect square root)
                if (i != num / i) {
                    total += num / i;
                }
            }
        }

        return total == num;
    }
}
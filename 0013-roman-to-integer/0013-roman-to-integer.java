class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        
        // Start with the value of the last character
        int lastValue = getValue(chars[chars.length - 1]);
        int ans = lastValue;

        // Iterate backwards from the second-to-last character
        for (int i = chars.length - 2; i >= 0; i--) {
            int currentValue = getValue(chars[i]);

            if (currentValue < lastValue) {
                ans -= currentValue;
            } else {
                ans += currentValue;
            }
            lastValue = currentValue;
        }
        
        return ans;
    }

    // High-performance primitive lookup using a switch statement
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

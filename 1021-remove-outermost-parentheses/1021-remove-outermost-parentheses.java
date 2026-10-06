class Solution {
    public String removeOuterParentheses(String s) {
        // Pre-size the buffer to match string length to prevent dynamic re-allocations
        StringBuilder sb = new StringBuilder(s.length());
        
        // Tracks current depth level of nested parentheses
        int count = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Post-increment (count++): Check condition BEFORE incrementing.
                // - If count == 0: It's the outermost '(', so DO NOT append. Then count becomes 1.
                // - If count > 0: It's an inner '(', so APPEND it. Then count increases by 1.
                if (count++ > 0) {
                    sb.append(c);
                }
            } else {
                // Pre-decrement (--count): Decrement count BEFORE checking condition.
                // - If count > 1: After decrement, count > 0, meaning it's an inner ')' -> APPEND it.
                // - If count == 1: After decrement, count == 0, meaning it's the outermost ')' -> DO NOT append.
                if (--count > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
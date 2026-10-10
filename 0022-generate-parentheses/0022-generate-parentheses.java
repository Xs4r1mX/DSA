class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        // Pre-allocate StringBuilder capacity to 2 * n to avoid internal resizing
        StringBuilder sb = new StringBuilder(2 * n);
        generate(sb, 0, 0, n, ans);
        return ans;
    }

    private void generate(StringBuilder current, int open, int close, int limit, List<String> result) {
        // Base case: when the string reaches the required length
        if (current.length() == 2 * limit) {
            result.add(current.toString());
            return;
        }

        // Add opening parenthesis if we haven't reached the limit
        if (open < limit) {
            current.append('(');
            generate(current, open + 1, close, limit, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Add closing parenthesis if it doesn't exceed the opening count
        if (close < open) {
            current.append(')');
            generate(current, open, close + 1, limit, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
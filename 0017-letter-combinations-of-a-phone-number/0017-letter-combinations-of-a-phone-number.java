import java.util.ArrayList;
import java.util.List;

class Solution {
    // Pre-defined lookup array is faster and cleaner than a switch statement
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        
        generate(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void generate(String digits, int index, StringBuilder current, List<String> ans) {
        // Base case: if the current combination length matches digits length, add it
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        
        String letters = MAPPING[digits.charAt(index) - '0'];
        
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));                     // 1. Choose
            generate(digits, index + 1, current, ans);             // 2. Explore
            current.deleteCharAt(current.length() - 1);            // 3. Un-choose (Backtrack)
        }
    }
}
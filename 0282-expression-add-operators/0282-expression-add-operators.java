import java.util.*;

class Solution {
    public List<String> addOperators(String s, int target) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        dfs(result, "", s, target, 0, 0, 0);
        return result;
    }
    
    private void dfs(List<String> result, String path, String num, int target, int index, long eval, long tail) {
        // Base case: if we have reached the end of the string
        if (index == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        
        // Iterate through all possible substrings starting from index
        for (int i = index; i < num.length(); i++) {
            // Avoid leading zeros (e.g., "05" is invalid, but "0" is valid)
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            
            long curr = Long.parseLong(num.substring(index, i + 1));
            String currStr = num.substring(index, i + 1);
            
            // If it's the first number in the expression, no operator is needed
            if (index == 0) {
                dfs(result, path + currStr, num, target, i + 1, curr, curr);
            } else {
                // Try addition '+'
                dfs(result, path + "+" + currStr, num, target, i + 1, eval + curr, curr);
                
                // Try subtraction '-'
                dfs(result, path + "-" + currStr, num, target, i + 1, eval - curr, -curr);
                
                // Try multiplication '*' (handle precedence by reversing the previous tail)
                dfs(result, path + "*" + currStr, num, target, i + 1, eval - tail + (tail * curr), tail * curr);
            }
        }
    }
}
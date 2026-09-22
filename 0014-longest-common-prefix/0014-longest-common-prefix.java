class Solution {
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return "";
        if (str.length == 1) return str[0];

        String current = str[0];

        for (int i = 0; i < current.length(); i++) {
            char ch = current.charAt(i);
            for (int j = 1; j < str.length; j++) {
                // If index i exceeds string j's length OR characters don't match
                if (i == str[j].length() || str[j].charAt(i) != ch) {
                    return current.substring(0, i);
                }
            }
        }

        // Entire first string was a common prefix
        return current;
    }
}
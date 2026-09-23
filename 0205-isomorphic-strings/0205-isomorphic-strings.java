class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Array size 256 covers all standard extended ASCII characters
        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If the last seen positions don't match, mapping is broken
            if (lastSeenS[charS] != lastSeenT[charT]) {
                return false;
            }

            // Store current position (i + 1 to avoid 0 collision with default initial values)
            lastSeenS[charS] = i + 1;
            lastSeenT[charT] = i + 1;
        }

        return true;
    }
}
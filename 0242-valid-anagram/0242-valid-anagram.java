class Solution {
    public boolean isAnagram(String s, String t) {
        // Quick exit if lengths don't match
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        // Increment and decrement in a single loop without creating char arrays
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts return to zero
        for (int n : count) {
            if (n != 0) return false;
        }

        return true;
    }
}
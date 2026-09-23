import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapS2T = new HashMap<>();
        Map<Character, Character> mapT2S = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check s -> t mapping
            if (mapS2T.containsKey(charS)) {
                if (mapS2T.get(charS) != charT) return false;
            } else {
                mapS2T.put(charS, charT);
            }

            // Check t -> s mapping
            if (mapT2S.containsKey(charT)) {
                if (mapT2S.get(charT) != charS) return false;
            } else {
                mapT2S.put(charT, charS);
            }
        }

        return true;
    }
}
import java.util.HashMap;
import java.util.Map;

public class Rubrik2 {

    public int findSubArray(String haystack, String needle) {
        // check if the length of needle is larger than the length of haystack
        if (needle.length() > haystack.length()) {
            return -1;
        }
        // store the occurrence of characters in needle in a hashmap
        Map<Character, Integer> needleMap = new HashMap<Character, Integer>();
        Map<Character, Integer> haystackMap = new HashMap<Character, Integer>();
        for (int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            needleMap.put(c, needleMap.getOrDefault(c, 0) + 1);
        }
        // start matching the characters of needle with the character of haystack
        // increment count when a character matches
        int count = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            haystackMap.put(c, haystackMap.getOrDefault(i, 0) + 1);
            
            if (needleMap.containsKey(haystack.charAt(i))) {
                count++;
            }
            if (count == needle.length()) {
                char tempChar = haystack.charAt(start);
                while (haystackMap.get(tempChar) > needleMap.getOrDefault(tempChar, 0)) {
                    haystackMap.put(tempChar, haystackMap.get(tempChar) - 1);
                    start++;
                }
            }
            int windowSize = i - start + 1;
            if (windowSize < min) {
                min = windowSize;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

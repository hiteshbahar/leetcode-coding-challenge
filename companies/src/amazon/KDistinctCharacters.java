package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDistinctCharacters {
    public static void main(String[] args) {
        String inputStr = "awaglknagawunagwkwag";
        String inputStr2 = "abcdacdbbaaccdbacd";
        int K = 4;
        List<String> kDistinctResult = kDistinctCharacters(inputStr2, K);
        System.out.println("kDistinctResult " + kDistinctResult.size());
        System.out.println("kDistinctResult " + kDistinctResult);
    }
    /**
     * Given an inputStr and a number K, find all the substrings of size K with K distinct characters
     * Substrings are not necessarily distinct
     * @param inputStr  given string
     * @param K the number of distinct characters in the string
     * @return  a list of substrings
     */
    public static List<String> kDistinctCharacters(String inputStr, int K) {
        List<String> result = new ArrayList<>();
        if (inputStr == null || inputStr.length() < K) {
            return result;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right <= inputStr.length()) {
            if (right - left == K) {
                result.add(inputStr.substring(left, right));
                if (right == inputStr.length()) break;
                set.remove(inputStr.charAt(left));
                left++;
            }
            char c = inputStr.charAt(right);
            while (left < right && set.contains(c)) {
                set.remove(inputStr.charAt(left));
                left++;
            }
            set.add(c);
            right++;
        }
        return result;
    }
}

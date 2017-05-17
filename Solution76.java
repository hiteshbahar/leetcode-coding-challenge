import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        while (start < s.length()) {
            Map<Character, Integer> currMap = new HashMap<Character, Integer>(tMap);
            int end = start;
            
            while (end < s.length() && !currMap.isEmpty()) {
                char c = s.charAt(end);
                if (currMap.containsKey(c)) {
                    if (currMap.get(c) == 1) {
                        currMap.remove(c);
                    } else {
                        currMap.put(c, currMap.get(c) - 1);
                    }
                }
                end++;
            }
            if (currMap.isEmpty() && (end - start) < min) {
                min = end - start;
                result = s.substring(start, end);
            }
            start++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Solution76 slu = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(slu.minWindow(s, t));
    }
}

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow2(String s, String t) {
        int[] tMap = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        int count = t.length();
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int head = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            if (tMap[c] > 0) {      // char in t
                count--;               
            }
            tMap[c]--; 
            end++;
            while (count == 0) {      // update start pointer
                if (end - start < min) {
                    min = end - start;
                    head = start;
                }
                char ch = s.charAt(start);
                tMap[ch]++;
                if (tMap[ch] > 0) {
                    count++;              
                }
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? "":s.substring(head, head + min);
    }
    
    /*Version 1: O(N^2) TLE too slow*/
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
        String s = "ADOBECODEAABC";
        String t = "ABC";
        System.out.print(slu.minWindow(s, t));
        System.out.println();
        System.out.println(slu.minWindow2(s, t));
    }
}

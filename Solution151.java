
public class Solution151 {
    public static String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        if (s.trim().isEmpty() || s.length() == 1) {
            return s.trim();
        }
        String[] words = s.trim().split(" ");
        reverse(words, 0, words.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.trim().isEmpty()) {
                continue;
            }
            sb.append(word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private static void reverse(String[] words, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            while (words[i].trim().isEmpty()) {
                i++;
            }
            while (words[j].trim().isEmpty()) {
                j--;
            }
            if (i < j) {
                String temp = words[i];
                words[i] = words[j];
                words[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "   b    a";
        System.out.println(reverseWords(s));
    }

}

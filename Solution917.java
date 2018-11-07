
public class Solution917 {

    public static void main(String[] args) {
        String s1 = "a-bC-dEf-ghIj";
        String s2 = "7_28]";
        String reversed = reverseOnlyLetters(s1);
        System.out.println(reversed);

    }
    public static String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;
        StringBuilder sb = new StringBuilder(S);
        int left = 0, right = sb.length() - 1;
        
        while (left <= right) {
            while (left < right && !Character.isLetter(sb.charAt(left))) {
                left++;
            }
            while (right > left && !Character.isLetter(sb.charAt(right))) {
                right--;
            }
            System.out.println("left: " + left + " " + sb.charAt(left) + ", rignt: " + right + " " + sb.charAt(right));
            char charL = sb.charAt(left);
            char charR = sb.charAt(right);
            sb.setCharAt(right, charL);
            sb.setCharAt(left, charR);
            left++;
            right--;
            System.out.println("after exchanging: " + sb.toString());
        }
        return sb.toString();
    }
    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

}

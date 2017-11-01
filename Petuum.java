
public class Petuum {

    public static String removeDuplicateLetters(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int n = str.length();
        int k = 0;
        char[] strArr = str.toCharArray();
        for (int i = 1; i < n; i++) {
            if (k == 0 || strArr[i] != strArr[i - 1]) {
                strArr[k++] = strArr[i];
            } else {
                k--;
            }
        }
        return new String(strArr, 0, k);
    }
    public static void main(String[] args) {
        String str1 = "abbac";
        String str2 = "aaadcc";
        System.out.println(removeDuplicateLetters(str1));
        System.out.println(removeDuplicateLetters(str2));

    }

}

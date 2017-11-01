
public class Petuum {

    public static String removeSameAdjacentLetters(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int n = str.length();
        int k = 0;
        char[] strArr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            // when length is equal to 0, it is always a new start
            if (k == 0 || strArr[i] != strArr[k - 1]) {
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
        System.out.println(removeSameAdjacentLetters(str1));
        System.out.println(removeSameAdjacentLetters(str2));

    }

}

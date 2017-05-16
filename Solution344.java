
public class Solution344 {
    public String reverseString(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] strChar = s.toCharArray();
        while (left < right) {
            swap(strChar, left, right);
            left++;
            right--;
        }
        return String.valueOf(strChar);
    }
    public void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

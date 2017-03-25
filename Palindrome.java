
public class Palindrome {
    public static boolean isPalindrome(int x) {
        if ((x % 10 == 0) && (x / 10 == 0)) {
            return true;
        }
        int digit;
        int reverse = 0;
        int remain = x;
        while (remain != 0) {
            digit = remain % 10;
            System.out.println(digit);
            remain = remain / 10;
            reverse = reverse * 10 + digit;
        }
        System.out.println(reverse);
        if (x == reverse) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isPalindrome(-2147447412));
    }

}


public class Solution168 {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char c = (char)(n % 26 + 'A');
            sb.append(c);
            n = n / 26;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution168 s = new Solution168();
        System.out.println(s.convertToTitle(53));
    }

}

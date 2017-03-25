
public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        // state dp[i] represents the way to decode the string length in i.
        int[] dp = new int[n + 1];
        
        // initialization
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        // function
        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one <= 9 && one >= 1) {
                dp[i] += dp[i - 1];
            }
            if (two <= 26 && two >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        
        // answer
        return dp[n];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Solution91 slu = new Solution91();
        System.out.println(slu.numDecodings("11"));
    }

}

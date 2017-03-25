import java.util.Stack;

public class Solution394 {

    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> sbStack = new Stack<StringBuilder>();
        Stack<Integer> numStack = new Stack<Integer>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                sbStack.push(sb);
                numStack.push(num);
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                num = numStack.pop();
                StringBuilder temp = sb;
                sb = sbStack.pop();
                for (int i = 0; i < num; i++) {
                    sb.append(temp);
                }
                num = 0;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Solution394 slu = new Solution394();
        String s = "3[a2[c]]";
        System.out.println(slu.decodeString(s));
    }

}

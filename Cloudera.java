import java.util.Stack;

public class Cloudera {
    
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public int findComplement(int num) {
        int count = 0;
        int curr = num;
        if (num == 0) {
            return 1;
        }
        while (curr != 0) {
            curr = curr >> 1;
            count = (count << 1) | 1;
        }
        return num ^ count;
    }
    public String mergeString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            sb.append(s1.charAt(index));
            sb.append(s2.charAt(index));
            index++;
        }
        while (index < s1.length()) {
            sb.append(s1.charAt(index));
            index++;
        }
        while (index < s2.length()) {
            sb.append(s2.charAt(index));
            index++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cloudera c = new Cloudera();
        String s1 = "abc";
        String s2 = "defg";
        System.out.println(c.mergeString(s1, s2));

    }

}

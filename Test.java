import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = new String[4];
        strs[0] = "apple";
        strs[1] = "ape";
        strs[2] = "april";
        strs[3] = "alication";
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

}

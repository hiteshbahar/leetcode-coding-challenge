import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LiveRamp1 {
    private static String time(int a, int b, int c, int d) {
        List<Integer> numList = new LinkedList<Integer>();
        numList.add(a);
        numList.add(b);
        numList.add(c);
        numList.add(d);
        Collections.sort(numList, Collections.reverseOrder());
        int[] digit = new int[4];
        // digit[0]
        for (Integer i : numList) {
            if (i <= 2) {
                digit[0] = i;
                numList.remove(i);
                break;
            }
        }
        // digit[1]
        for (Integer i : numList) {
            if (digit[0] == 2) {
                if (i <= 3) {
                    digit[1] = i;
                    numList.remove(i);
                } else {
                    continue;
                }
            } else {
                digit[1] = i;
                numList.remove(i);
                break;
            }
        }
        // digit[2]
        for (Integer i : numList) {
            if (i <= 5) {
                digit[2] = i;
                numList.remove(i);
                break;
            }
        }
        // digit[3]
        //System.out.println(numList.size());
        digit[3] = numList.get(0);

        StringBuilder sb = new StringBuilder();
        sb.append(digit[0]);
        sb.append(digit[1]);
        sb.append(":");
        sb.append(digit[2]);
        sb.append(digit[3]);
        return sb.toString();
    }
    public static void main(String[] args) {
        String t1 = time(3, 9, 1, 4);
        String t2 = time(9, 5, 7, 1);
        String t3 = time(2, 2, 7, 6);
        String t4 = time(2, 6, 6, 1);
        String t5 = time(0, 5, 9, 8);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
    }

}

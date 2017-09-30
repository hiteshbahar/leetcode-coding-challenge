import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Coursera {
    public void finalPrice(int[] prices) {
        //print two lines of output
        // 1. the cost for all n items
        // 2. indices of any non-discounted items space-separated
        int n = prices.length;
        int[] result = new int[n];
        // initialization to result
        for (int i = 0; i < n; i++) {
            result[i] = prices[i];
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] > price) {
                int originalPrice = prices[stack.peek()];
                result[stack.pop()] = originalPrice - price;
            }
            stack.push(i);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += result[i];
        }
        System.out.println(total);
        for (int i = 0; i < n; i++) {
            if (result[i] == prices[i]) {
                System.out.print(i);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
    public long playList(int N, int L, int K) {
        if (L > N) {
            if (L >= K + 1) {
                return 0;
            }
        }
        int a = L / (K + 1);
        int b = L  % (K + 1);
        long partA = 1;
        long partB = 1;
        for (int i = 0; i <= K; i++) {
            partA *= N-i;
        }
        partA = (long) Math.pow(partA, a);
        for (int i = 0; i < b; i++) {
            partB *= N-i;
        }
        return (long) (partA * partB % (1e9 + 7));
    }
    public String[] royalGames(String[] names) {
        Queue<String> pq = new PriorityQueue<String>(10, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] name1 = s1.split(" ");
                String[] name2 = s2.split(" ");
                if (name1[0].equals(name2[0])) {
                    return getRomanNum(name2[1]) - getRomanNum(name1[1]);
                } else {
                    return name1[0].compareTo(name2[0]);
                }
            }
        });
        for (int i = 0; i < names.length; i++) {
            pq.offer(names[i]);
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = pq.poll();
        }
        return names;
    }
    private int getRomanNum(String r1) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        for (int i = 0; i < r1.length(); i++) {
            int curr = map.get(r1.charAt(i));
            if (i < r1.length() - 1 && curr < map.get(r1.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Coursera c = new Coursera();
        /*finalPrice*/
//        int[] prices = new int[]{5,1,3,4,6,2};
//        c.finalPrice(prices);
        /* playList*/
//        System.out.println(c.playList(20, 9, 3));
//        System.out.println(Math.pow(116280,2) * 20 % (1e9 + 7));
        /* royalNames */
        String[] names = new String[]{"Albert II","Polo IV","Alw V","Elizabeth XXV", "Albert XL","Polo XLVI"};
        names = c.royalGames(names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}

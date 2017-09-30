import java.util.ArrayList;
import java.util.List;
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
    public static void main(String[] args) {
        Coursera c = new Coursera();
        int[] prices = new int[]{5,1,3,4,6,2};
        c.finalPrice(prices);
    }
}

import java.util.*;

public class Solution826 {
    public static void main(String[] args) {
        int[] difficulty = {5,50,92,21,24,70,17,63,30,53};
        int[] profit = {68,100,3,99,56,43,26,93,55,25};
        int[] worker = {96,3,55,30,11,58,68,36,26,1};
        int total = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(total);
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        
        Collections.sort(list, Comparator.comparingInt(d -> d[0]));
        Arrays.sort(worker);
                
        int total = 0, currMax = 0;
        int ptr = 0;
        for (int a : worker) {
            while (ptr < profit.length && a >= list.get(ptr)[0]) {
                currMax = Math.max(currMax, list.get(ptr)[1]);
                ptr++;
            }
            total += currMax;
        }
        return total;
    }
}

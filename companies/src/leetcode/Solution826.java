package leetcode;

import java.util.*;

public class Solution826 {
    public static void main(String[] args) {
        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};
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
                currMax = Math.max(currMax,list.get(ptr)[1]);
                ptr++;
            }
            total += currMax;
        }
        return total;
    }
}

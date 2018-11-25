package amazon;

import java.util.ArrayList;
import java.util.List;

public class MaxMinPath {
    public static void main(String[] args) {
        int[][] matrix = {{8,4,3}, {6,7,9}};
        System.out.println("dfs: " + maximumMinimumPath(matrix));
        System.out.println("dp: " + maxMinPathDP(matrix));
    }
    public static int maximumMinimumPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        dfs(matrix, 0, 0, new int[] {matrix[0][0]}, result);
        int max = Integer.MIN_VALUE;
        for (int r : result) {
            max = Math.max(max, r);
        }
        return max;
    }
    private static void dfs(int[][] matrix, int i, int j, int[] min, List<Integer> minList) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            minList.add(min[0]);
            min = new int[]{matrix[0][0]};
            return;
        }
        min[0] = Math.min(min[0], matrix[i][j]);
        // down
        dfs(matrix, i+1, j, min, minList);
        // right
        dfs(matrix, i, j+1, min, minList);
    }
    public static int maxMinPathDP(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
                if (i-1 >= 0) {
                    a = Math.min(matrix[i][j], matrix[i-1][j]);
                }
                if (j-1 >= 0) {
                    b = Math.min(matrix[i][j], matrix[i][j-1]);
                }
                matrix[i][j] = Math.max(a,b);
            }
        }
        return matrix[m-1][n-1];
    }
}

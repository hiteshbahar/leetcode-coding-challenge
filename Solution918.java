
public class Solution918 {

    public static void main(String[] args) {
        int[] A = {1,-2,3,-2};
        int max = maxSubarraySumCircular(A);
        System.out.println(max);

    }
    public static int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < i + n; j++) {
//                if (j > i && A[j%n] < 0) break;
                curr += A[j%n];
                max = Math.max(curr, max);
            }
            
        }
        return max;
    }

}

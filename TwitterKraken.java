
public class TwitterKraken {

    public static int krakenCount(int m, int n){
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // state: f[i][j] represents total paths to position (i, j).
        int[][] f = new int[m][n];
        // Initialization
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        int k = m > n ? n : m;
        for (int i = 1; i < k; i++) {
            f[i][i] = 1;
        }
        // funciton
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1] + f[i - 1][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(krakenCount(2, 3));
        System.out.println(krakenCount(2, 2));

    }

}

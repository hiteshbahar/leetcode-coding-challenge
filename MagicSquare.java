
public class MagicSquare {

    public static void main(String[] args) {
        int n = 3;
        int[][] square = new int[n][n];
        
        getSquare(square, n-1, n/2);
        printSquare(square);

    }
    public static void getSquare(int[][] square, int row, int col) {
        int n = square.length;
        square[row][col] = 1;
        
        for (int i = 2; i <= n*n; i++) {
            if (square[(row+1) % n][(col+1) % n] == 0) {
                row = (row+1) % n;
                col = (col+1) % n;
            } else {
                row = (row+n-1) % n;
            }
            square[row][col] = i;
        }
    }
    public static void printSquare(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}

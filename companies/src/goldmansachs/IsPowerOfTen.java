package goldmansachs;

public class IsPowerOfTen {
    public static void main(String[] args) {
        double input = Math.pow(10,0.5);
        System.out.println(isPowerOfTen(input));
    }

    /**
     * Judge if a number is the power of 10
     *
     * Possible questions to ask:
     *  1. what's the data type of the input?
     *  2. any restrictions on power? int, negative, or whatever
     * @param n
     * @return true if n is the power of 10, false if not
     */
    private static boolean isPowerOfTen(double n) {
        double power = Math.log10(n);
        System.out.println(power);
        System.out.println(Math.round(power));
        // widening primitive conversion will convert int to double
        return Double.isFinite(power) && Math.round(power) == power;
    }
}

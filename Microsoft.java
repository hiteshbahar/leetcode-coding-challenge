
public class Microsoft {

    public static boolean canCross(int[] stones) {
        return canCrossHelper(stones, 0, 0);
    }
    private static boolean canCrossHelper(int[] stones, int pos, int k) {
        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1) {
                continue;
            }
            if (gap > k + 1) {
                return false;
            }
            if (canCrossHelper(stones, i, gap)) {
                return true;
            }
        }
        return pos == stones.length - 1;
    }
    public static void main(String[] args) {
        int[] stones1 = new int[]{0,1,3,5,6,8,12,17};
        int[] stones2 = new int[]{0,1,2,3,4,8,9,11};

        System.out.println(canCross(stones1));
        System.out.println(canCross(stones2));

    }

}

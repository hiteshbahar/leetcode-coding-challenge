
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
    public static boolean canCrossBinary(int[] stones, int pos, int k) {
        for (int i = pos + 1; i < stones.length; i++) {
            int gap = i - pos;
            if (gap < k - 1) {
                continue;
            }
            if (gap > k + 1) {
                return false;
            }
            if (canCrossBinary(stones, i, gap)) {
                return true;
            }
        }
        return pos == stones.length - 1;
    }
    public static void main(String[] args) {
        int[] stones1 = new int[]{0,1,3,5,6,8,12,17};
        int[] stones2 = new int[]{0,1,2,3,4,8,9,11};
        int[] river = new int[stones1[stones1.length - 1] + 1];
        
        int stoneIndex = 0;
        for (int i = 0; i < river.length; i++) {
            if (i == stones1[stoneIndex]) {
                river[i] = 1;
                stoneIndex++;
            }
        }

        System.out.println(canCross(stones1));
        System.out.println(canCross(stones2));
        
        for (int i = 0; i < river.length; i++) {
            System.out.print(river[i] + " ");
        }
        System.out.println();
        System.out.println(canCrossBinary(river, 0, 0));
        

    }

}

import java.util.HashMap;
import java.util.Map;

public class Zappos {
    public static String reverseWord(String sentence) {

        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        char[] arr = sentence.toCharArray();
        while (end <= arr.length) {
            if (Character.isSpaceChar(arr[start])) {
                sb.append(arr[start]);
                start++;
                end++;
            } else {
                if (end != arr.length && !Character.isSpaceChar(arr[end])) {
                    end++;
                    continue;
                }
                StringBuilder temp = new StringBuilder(sentence.substring(start, end));
                sb.append(temp.reverse());
                start = end;
                if (end == arr.length) {
                    break;
                }
            }
        }
        return sb.toString();
    }
    public static int foundInBermudaTriangle(int x1, int y1, int x2, int y2, int x3, int y3,
            int px, int py, int bx, int by) {
        int temp1 = (y3 - y2) * (x2 - x1);
        int temp2 = (y2 - y1) * (x3 - x2);
        if (temp1 == temp2) {
            return 0;
        }
        // calculating the barycentric coordinates
        double pAlpha = ((double)((y2 - y3)*(px - x3) + (x3 - x2)*(py - y3))) /
                ((double)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3)));
        double pBeta = ((double)((y3 - y1)*(px - x3) + (x1 - x3)*(py - y3))) /
                ((double)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3)));
        double pGamma = 1.0 - pAlpha - pBeta;
        
        double bAlpha = ((double)((y2 - y3)*(bx - x3) + (x3 - x2)*(by - y3))) /
                ((double)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3)));
        double bBeta = ((double)((y3 - y1)*(bx - x3) + (x1 - x3)*(by - y3))) /
                ((double)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3)));
        double bGamma = 1.0 - bAlpha - bBeta;
        
        boolean pInTriangle = (pAlpha >= 0) && (pBeta >= 0) && (pGamma >= 0);
        boolean bInTriangle = (bAlpha >= 0) && (bBeta >= 0) && (bGamma >= 0);
        if (pInTriangle && !bInTriangle) {
            return 1;
        }
        if (bInTriangle && !pInTriangle) {
            return 2;
        }
        if (bInTriangle && pInTriangle) {
            return 3;
        }
        return 4;
    }
    public static boolean twoSum(int[] batteryOne, int[] batteryTwo, int target) {
        Map<Integer, Integer> mapOne = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapTwo = new HashMap<Integer, Integer>();
        for (int i = 0; i < batteryOne.length; i++) {
            mapOne.put(batteryOne[i], mapOne.getOrDefault(batteryOne[i], 0) + 1);
        }
        for (int i = 0; i < batteryTwo.length; i++) {
            mapTwo.put(batteryTwo[i], mapTwo.getOrDefault(batteryTwo[i], 0) + 1);
        }
        for (int i : mapOne.keySet()) {
            if (mapTwo.containsKey(target - i)) {
                return true;
            }
        }
        return false;
    }
    public static int gameOfThrones(int[][] venue) {
        if (venue == null || venue.length == 0 || venue[0].length == 0) {
            return 0;
        }

        int m = venue.length;
        int n = venue[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (venue[i][j] == 1) {
                    count++;
                    mark(venue, i, j);
                }
            }
        }
        return count;
    }
    private static void mark(int[][] venue, int i, int j) {
        if (i < venue.length && i >= 0 && j < venue[0].length && j >= 0 && venue[i][j] == 1) {
            venue[i][j] = 0;
            mark(venue, i - 1, j);
            mark(venue, i, j - 1);
            mark(venue, i + 1, j);
            mark(venue, i, j + 1);
            mark(venue, i - 1, j - 1);
            mark(venue, i - 1, j + 1);
            mark(venue, i + 1, j - 1);
            mark(venue, i + 1, j + 1);
        }
    }
    
    public static String findLowestNumber(String coordinates, int remove) {
        if (coordinates == null || coordinates.isEmpty() || remove >= coordinates.length()) {
            return "0";
        }

        if (remove == 0) {
            return coordinates;
        }

        StringBuilder sb = new StringBuilder();
        findLowestNumberHelper(coordinates, remove, sb);
        return sb.toString();
    }
    private static void findLowestNumberHelper(String coordinates, int remove, StringBuilder sb) {
        if (remove == 0) {
            sb.append(coordinates);
            return;
        }
        
        int n = coordinates.length();
        if (n <= remove) {
            return;
        }
        
        int minIndex = 0;
        for (int i = 1; i <= remove ; i++) {
            if (coordinates.charAt(i) < coordinates.charAt(minIndex)) {
                minIndex = i;
            }
        }
     
        // Append the smallest character to result
        sb.append(coordinates.charAt(minIndex));
     
        // substring starting from minIndex+1 to str.length() - 1.
        String newStr = coordinates.substring(minIndex + 1, n);
     
        // Recur for the above substring and remove equals to remove - minIndex.
        findLowestNumberHelper(newStr, remove - minIndex, sb);
    }
    public static void main(String[] args) {
        // 1. reverse words in a sentence.
        
        String sentence = " Let's meet in the owlery today";
        System.out.println(sentence);
        System.out.println(sentence.length());
        System.out.println(reverseWord(sentence));
        System.out.println(reverseWord(sentence).length());
        
        // 2. determine points in a triangle.
//        System.out.println(foundInBermudaTriangle(3, 1, 7, 1, 5, 5, 1, 1, 2, 2));
        
        // 3. two Sum.
//        int[] batteryOne = {6, 3, 1, 9, 5, 4, 0, 1, -29, 12, 45, 2, 6};
//        int[] batteryTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
//        int target = 25;
//        System.out.println(twoSum(batteryOne, batteryTwo, target));
        
        // 4. number of islands
//        int[][] venue1 = {
//                {0, 0, 0, 0, 1, 0, 0, 0}, 
//                {0, 0, 1, 0, 0, 0, 0, 1}, 
//                {0, 1, 1, 1, 0, 0, 0, 0}
//                };
//        System.out.println("m = " + venue1.length + ", " + "n = " + venue1[0].length);
//        System.out.println(gameOfThrones(venue1));
//        
//        int[][] venue2 = {
//                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0},               
//                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//                };
//
//        System.out.println("m = " + venue2.length + ", " + "n = " + venue2[0].length);
//        System.out.println(gameOfThrones(venue2));
        
        // 5. find lowest number.
//        String coordinates = "746209249";
//        int remove = 5;
//        System.out.println(findLowestNumber(coordinates, remove));
    }

}

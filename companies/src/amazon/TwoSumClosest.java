package amazon;

import java.util.*;

public class TwoSumClosest {
    public static void main(String[] args) {

//        Integer[][] forwardArr = {{1,5000}, {2,10000}, {3,9000}, {4,2000}};
//        Integer[][] backwardArr = {{1,7000}, {2,12000}, {3,8000}, {4,5000}};

        Integer[][] forwardArr = {{1,2}, {3,4}};
        Integer[][] backwardArr = {{4,1}, {5,6}};
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();

        for (Integer[] a : forwardArr) {
            forward.add(new ArrayList<>(Arrays.asList(a)));
        }

        for (Integer[] b : backwardArr) {
            backward.add(new ArrayList<>(Arrays.asList(b)));
        }

        int target = 8;

        List<List<Integer>> twoSumClosestResult = twoSumClosest(forward, backward, target);
        System.out.println("twoSumClosestResult " + twoSumClosestResult);
    }
    /**
     * find the pairs that are closest to the target mileage but not exceed(<=)
     * @param forward List of List, [id, forward_mileage]
     * @param backward List of List, [id, backward_mileage]
     * @param target target mileage
     * @return
     */
    public static List<List<Integer>> twoSumClosest(List<List<Integer>> forward, List<List<Integer>> backward, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(forward, Comparator.comparingInt(l -> l.get(1)));
        Collections.sort(backward, (l1,l2) -> (l2.get(1) - l1.get(1)));

        int ptr1 = 0;
        int ptr2 = 0;
        int m = forward.size();
        int n = backward.size();
        int min = Integer.MIN_VALUE;
        while (ptr1 < m && ptr2 < n) {
            List<Integer> pair1 = forward.get(ptr1);
            List<Integer> pair2 = backward.get(ptr2);
            int curr = pair1.get(1) + pair2.get(1);
            int diff = curr - target;
            if (diff <= 0 && diff >= min) {
                if (diff > min) {
                    result = new ArrayList<>();
                }
                Integer[] ids = new Integer[] {pair1.get(0), pair2.get(0)};
                result.add(new ArrayList<>(Arrays.asList(ids)));
                min = diff;
            }
            if (diff < 0) {
                ptr1++;
            } else {
                ptr2++;
            }

        }
        return result;
    }
}

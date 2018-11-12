
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Amazon {

    public static void main(String[] args) {
        /*
        // K nearest points test
        List<List<Integer>> points = new ArrayList<>();
        Integer[][] arr = {{1,2}, {1,3}, {1,1}, {2,1}, {3,1}};
        for (Integer[] a : arr) {
            points.add(new ArrayList<>(Arrays.asList(a)));
        }

        List<List<Integer>> kNearestPointsresult = kNearestPoints(points, 5, 3);
        for (List<Integer> r : kNearestPointsresult) {
            System.out.println(r.get(0) + ", " + r.get(1));
        }
        */

        // two sum closest test
        Integer[][] forwardArr = {{1,5000}, {2,10000}, {3,9000}, {4,2000}};
        Integer[][] backwardArr = {{1,7000}, {2,12000}, {3,8000}, {4,5000}};
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();

        for (Integer[] a : forwardArr) {
            forward.add(new ArrayList<>(Arrays.asList(a)));
        }

        for (Integer[] b : backwardArr) {
            backward.add(new ArrayList<>(Arrays.asList(b)));
        }

        int target = 11000;

        List<List<Integer>> twoSumClosestResult = twoSumClosest(forward, backward, target);
        System.out.println("twoSumClosestResult " + twoSumClosestResult);

    }
    /**
     * find k closest points near origin (0,0)
     * @param points list of a list points
     * @param N the number of points in the list
     * @param k number of points to be selected
     * @return
     */
    public static List<List<Integer>> kNearestPoints(List<List<Integer>> points, int N, int k) {
        if (k >= N) {
            Collections.sort(points, Comparator.comparingInt(p -> getDist(p)));
            return points;
        }
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(p -> getDist(p)));
        for (List<Integer> p : points) {
            queue.offer(p);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = k; i > 0; i--) {
            result.add(queue.poll());
        }
        return result;
    }

    public static int getDist(List<Integer> list) {
        return (int)(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2));
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
        // TODO: check if forward and backward are normal List<List<Integer>>
        Collections.sort(forward, Comparator.comparingInt(l -> l.get(1)));
        Collections.sort(backward, (l1,l2) -> (l2.get(1) - l1.get(1)));

        int ptr1 = 0;
        int ptr2 = 0;
        int m = forward.size();
        int n = backward.size();
        int min = Integer.MAX_VALUE;
        while (ptr1 < m && ptr2 < n) {
            List<Integer> pair1 = forward.get(ptr1);
            List<Integer> pair2 = backward.get(ptr2);
            int curr = pair1.get(1) + pair2.get(1);
            int diff = curr - target;
            int absDiff = Math.abs(diff);
            if (absDiff <= min) {
                if (absDiff < min) {
                    result = new ArrayList<>();
                }
                System.out.println("diff " + diff);
                Integer[] ids = new Integer[] {pair1.get(0), pair2.get(0)};
                result.add(new ArrayList<>(Arrays.asList(ids)));
                min = absDiff;
            }
            if (diff < 0) {
                ptr1++;
            } else {
                ptr2++;
            }

        }
        System.out.println("result " + result);
        return result;
    }
}

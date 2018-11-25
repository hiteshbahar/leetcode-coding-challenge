package amazon;

import java.util.*;

public class KNearestPoints {
    public static void main(String[] args) {

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
        return (int)(Math.sqrt(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2)));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Amazon {

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<List<Integer>>();
        Integer[][] arr = {{1,2}, {1,3}, {1,1}, {2,1}, {3,1}};
        for (Integer[] a : arr) {
            points.add(new ArrayList<Integer>(Arrays.asList(a)));
        }
        
        List<List<Integer>> result = kNearestPoints(points, 5, 3);
        for (List<Integer> r : result) {
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
            Collections.sort(points, (l1,l2) -> getDist(l1) - getDist(l2));
            return points;
        }
        Queue<List<Integer>> queue = new PriorityQueue<List<Integer>>((l1,l2) -> getDist(l1) - getDist(l2));
        for (List<Integer> p : points) {
            queue.offer(p);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = k; i > 0; i--) {
            result.add(queue.poll());
        }
        return result;
    }
    public static int getDist(List<Integer> list) {
        return (int)(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2));
    }
}

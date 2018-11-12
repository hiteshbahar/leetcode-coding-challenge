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
    /**
     * find the pairs that are closest to the target mileage
     * @param forward List of List, [id, forward_mileage]
     * @param backward List of List, [id, backward_mileage]
     * @param target target mileage
     * @return
     */
    public static List<List<Integer>> twoSumClosest(List<List<Integer>> forward, List<List<Integer>> backward, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: check if forward and backward are normal List<List<Integer>>
        Collections.sort(forward, (l1,l2) -> l1.get(1) - l2.get(1));
        Collections.sort(backward, (l1,l2) -> l1.get(1) - l2.get(1));
        int ptr1 = 0;
        int ptr2 = 0;
        int m = forward.size();
        int n = backward.size();
        int min = Integer.MAX_VALUE;
        while (ptr1 < m && ptr2 < n) {
            List<Integer> pair1 = forward.get(ptr1);
            List<Integer> pair2 = backward.get(ptr2);
            int curr = pair1.get(1) + pair2.get(1);
            int diff = target - curr;
            if (diff == 0) {
                Integer[] ids = new Integer[] {pair1.get(0), pair2.get(0)};
                result.add(new ArrayList<Integer>(Arrays.asList(ids)));
            } else if (diff < 0) {
                
            }
        }
        return result;
    }
}

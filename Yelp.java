import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Yelp {

    // maintain a max value, every time when there is a number larger
    // than max, update the result list. When there is a tie, add the
    // word to the result. Declare a comparator in the PriorityQueue,
    // so that we can sort the result alphabetically.
    public List<String> getTopColors(List<List<String>> image) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        // O(mn), the total number of words in the input image
        for (List<String> list : image) {
            for (String word : list) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        Queue<String> resultQueue = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value >= max) {
                if (value > max) {
                    resultQueue.clear();
                    max = value;
                }
                resultQueue.offer(key);
            }
        }

        List<String> resultList = new ArrayList<String>();
        // remember to poll elements from priority queue rather than
        // using a for loop
        while (!resultQueue.isEmpty()) {
            resultList.add(resultQueue.poll());
        }
        return resultList;
    }
    public static void main(String[] args) {
        Yelp y = new Yelp();
        List<List<String>> image = new ArrayList<List<String>>();
        for (int i = 0; i < 3; i++) {
            image.add(new ArrayList<String>());
        }
        image.get(0).add("red");
        image.get(0).add("green");
        image.get(0).add("green");
        image.get(1).add("black");
        image.get(1).add("blue");
        image.get(1).add("black");
        image.get(2).add("red");
        image.get(2).add("yellow");
        image.get(2).add("yellow");
        List<String> result = y.getTopColors(image);
        for (String word : result) {
            System.out.println(word);
        }
        System.out.println(result.get(1));
        System.out.println("red".compareTo("green"));
    }

}

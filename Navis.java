import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Navis {

    public static void main(String[] args) {
        try {
            String s = null;
            s.substring(10);
        } catch (RuntimeException e) {
            System.out.println("runtime");
        } catch (Exception e) {
            System.out.println("other");
        }
    }
    public void topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                List<Integer> list = bucket[pos];
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
        }
    }

}

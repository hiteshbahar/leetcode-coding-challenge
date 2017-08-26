import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Yelp {
    /* V12: find restaurant with smallest index sum */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<String>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    list = new ArrayList<String>();
                    minSum = i + j;
                }
                list.add(list2[i]);
            }
        }
        // if cannot find the restaurant, return yelpwich
//        if (list.size() == 0) {
//            return "yelpwich";
//        }
        String[] result = new String[list.size()];
        int i = 0;
        for (String l : list) {
            result[i++] = l;
        }
        return result;
    }
    
    /* V11:
       maintain a max value, every time when there is a number larger
       than max, update the result list. When there is a tie, add the
       word to the result. Declare a comparator in the PriorityQueue,
       so that we can sort the result alphabetically.*/
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
    /* V9: Business Info
     * merge two lists as numReviews in descending order
     */
    class BusinessInfo {
        int id;
        int numReviews;
        BusinessInfo(int i, int n) {
            id = i;
            numReviews = n;
        }
    }
    /* Assume that the two input lists are ArrayLists*/
    public List<BusinessInfo> mergeBusinessInfo(List<BusinessInfo> list1, List<BusinessInfo> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }
        List<BusinessInfo> result = new ArrayList<BusinessInfo>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            BusinessInfo info1 = list1.get(index1);
            BusinessInfo info2 = list2.get(index2);
            if (info1.numReviews > info2.numReviews) {
                result.add(info1);
                index1++;
            } else {
                result.add(info2);
                index2++;
            }
        }
        while (index1 < list1.size()) {
            result.add(list1.get(index1));
            index1++;
        }
        while (index2 < list2.size()) {
            result.add(list2.get(index2));
            index2++;
        }
        return result;
    }
    /* Compress String*/
    public String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if (curr == prev) {
                count++;
            } else {
                sb.append(Integer.toString(count));
                sb.append(prev);
                count = 1;
            }
            if (i == str.length() - 1) {
                sb.append(Integer.toString(count));
                sb.append(curr);
            }
        }
        if (sb.length() > str.length()) {
            return str;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Yelp y = new Yelp();
        // test v11
        /*
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
        */
        
        // test V9
        /*
        List<BusinessInfo> list1 = new ArrayList<BusinessInfo>();
        List<BusinessInfo> list2 = new ArrayList<BusinessInfo>();
        list1.add(y.new BusinessInfo(0, 800));
        list1.add(y.new BusinessInfo(2, 700));
        list1.add(y.new BusinessInfo(5, 600));
        list2.add(y.new BusinessInfo(1, 900));
        list2.add(y.new BusinessInfo(3, 750));
        list2.add(y.new BusinessInfo(4, 740));
        
        List<BusinessInfo> result = y.mergeBusinessInfo(list1, list2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).id);
        }
        */
        // test compress string
        System.out.println(y.compress("aaaaaadddvv"));
        
    }

}

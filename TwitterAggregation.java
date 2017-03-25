import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwitterAggregation {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int count = 1;
        int startDate = 0;
        int endDate = 0;
        TreeMap<Integer, TreeMap<String, Integer>> map = 
                new TreeMap<Integer, TreeMap<String, Integer>>(Collections.reverseOrder());
        
        try {
            while ((input = br.readLine()) != null) {
                if (count == 1) {
                    String[] dates = input.split(",");
                    StringBuilder sb = new StringBuilder(dates[0].trim()).deleteCharAt(4);
                    startDate = Integer.parseInt(sb.toString());
                    sb = new StringBuilder(dates[1].trim()).deleteCharAt(4);
                    endDate = Integer.parseInt(sb.toString());     
                    count++;
                } else if (count == 2) {
                    count++;
                    continue;
                } else if (count == 3) {
                    String[] points = input.split(",");
                    if (points.length != 3) {
                        break;
                    }
                    String dateStr = new StringBuilder(points[0].trim()).deleteCharAt(4).substring(0, 6);
                    int date = Integer.parseInt(dateStr);
                    if (date > endDate || date <= startDate) {
                        continue;
                    }
                    String type = points[1].trim();
                    int number = Integer.parseInt(points[2].trim());
                    if (map.containsKey(date)) {
                        int total = map.get(date).getOrDefault(type, 0) + number;
                        map.get(date).put(type, total);
                    } else {
                        TreeMap<String, Integer> subMap = new TreeMap<String, Integer>();
                        subMap.put(type, number);
                        map.put(date, subMap);
                    }
                } 
            }
            for (Map.Entry<Integer, TreeMap<String, Integer>> entry : map.entrySet()) {
                StringBuilder sb = new StringBuilder();
                int date = entry.getKey();
                //build date.
                sb.append(date).insert(4, "-");
                sb.append(", ");
                TreeMap<String, Integer> engage = entry.getValue();
                for (String key : engage.keySet()) {
                    sb.append(key);
                    sb.append(", ");
                    sb.append(engage.get(key));
                    sb.append(", ");
                }
                System.out.println(sb.substring(0, sb.length() - 2));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

/**
 * Test cases:
2015-08, 2016-04

2015-08-15, clicks, 635
2016-03-24, app_installs, 683
2015-04-05, favorites, 763
2016-01-22, favorites, 788
2015-12-26, clicks, 525
2016-06-03, retweets, 101
2015-12-02, app_installs, 982
2016-09-17, app_installs, 770
2015-11-07, impressions, 245
2016-10-16, impressions, 567
*/

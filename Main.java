import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    
//    public int[] findWidest(int n, int[] nums) {
//        int[] result = new int[2];
//        return result;
//    }
    public void paragraph(int m, int n, String[] lines) {
        HashMap<String, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<String, Integer>();
        }
        for (int i = 0; i < n; i++) {
            String[] words = lines[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                map[i].put(words[j], map[i].getOrDefault(words[j], 0) + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            String[] words = lines[n + i - 1].split(" ");
            int[] total = new int[n];
            int max = 0;
            int maxIndex = 0;
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < words.length; j++) {
                    if (map[k].containsKey(words[j])) {
                        total[k] += map[k].get(words[j]);
                    }
                }
            }
            for (int l = 0; l < n; l++) {
                if (max < total[l]) {
                    max = total[l];
                    maxIndex = l;           
                }
            }
            System.out.println(lines[maxIndex]);
            for (int k = 0; k < n; k++) {
                total[k] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(args.length);
        Main test = new Main();
        //test.findWidest(Integer.valueOf(args[0]), )
        String line = "";
        int count = 0;
        int m = 0;
        int n = 0;
        String[] lines = new String[0];
        try {
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    String[] nums = line.split(" ");
                    n = Integer.valueOf(nums[0]);
                    m = Integer.valueOf(nums[1]);
                    count++;
                    break;
                }
                lines[count - 1] = new String(line);
                count++;
            }
            lines = new String[m + n];
            
            while (count != 0 && (line = br.readLine()) != null) {
                lines[count - 1] = new String(line);
                count++;
                if(count == m + n) {
                    break;
                }
            }
            test.paragraph(m, n, lines);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

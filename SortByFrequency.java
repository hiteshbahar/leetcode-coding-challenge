import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByFrequency {

    private class Info {
        int index, freq;
        public Info(int idx, int f) {
            index = idx;
            freq = f;
        }
    }
    public void sortByFreq (int[] nums) {
        HashMap<Integer, Info> map = new HashMap<Integer, Info>();
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = i, frq = 1;
            if (map.containsKey(nums[i])) {
                idx = map.get(nums[i]).index;
                frq = map.get(nums[i]).freq + 1;
            }
            map.put(nums[i], new Info(idx, frq));
        }
        
        PriorityQueue<Info> queue = new PriorityQueue<Info>(new Comparator<Info>() {
            @Override
            public int compare(Info num1, Info num2) {
                if (num1.freq == num2.freq) {
                    return num1.index - num2.index;
                }
                return num2.freq - num1.freq;
            }
        });
        for (Integer key : map.keySet()) {
            queue.offer(map.get(key));
        }
        int count = 0;
        while(!queue.isEmpty()) {
            Info curr = queue.poll();
            for (int i = 0; i < curr.freq; i++) {
                nums[count++] = temp[curr.index];
            }
        }
    }
    public static void main(String[] args) {
        SortByFrequency sbf = new SortByFrequency();
        int[] nums = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        sbf.sortByFreq(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        
    }

}

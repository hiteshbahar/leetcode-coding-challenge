import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            
        List<String> result = new ArrayList<String>();
        long prev = (long)lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            long after = i == nums.length ? upper + 1 : nums[i];
            if (prev + 2 == after) {
                result.add(String.valueOf(prev + 1));
            } else if (prev + 2 < after) {
                result.add(String.valueOf(prev + 1) + "->" + String.valueOf(after - 1));
            }
            prev = after;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution163 s = new Solution163();
        int[] nums = new int[]{2147483647};
        int lower = -2147483648;
        int upper = 2147483647;
        List<String> result = s.findMissingRanges(nums, lower, upper);
        for (String list : result) {
            System.out.println(list);
        }
        System.out.println(Math.ceil((double)2/2));
    }
}

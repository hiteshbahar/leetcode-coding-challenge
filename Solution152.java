
public class Solution152 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));

    }
    public static int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], prevMax = nums[0], prevMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(Math.max(prevMax * nums[i], prevMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(prevMax * nums[i], prevMin * nums[i]), nums[i]);
            max = Math.max(max, currMax);
            prevMax = currMax;
            prevMin = currMin;
        }
        return max;
    }

}

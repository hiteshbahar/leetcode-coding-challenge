
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = left + 1;
        while (left < nums.length) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            if (left >= nums.length - 1){
                break;
            }
            right = left + 1;
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            // reach the end of the array
            if (right == nums.length) {
                break;
            }
            // not 0
            swap(nums, left, right);
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        Solution283 s = new Solution283();
        int[] nums = new int[] {4,2,4,0,0,3,0,5,1,0};
        s.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

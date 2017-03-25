
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianHelper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
   }
   private static double findMedian(int[] nums, int start, int end) {
       int len = end - start + 1;
       int mid = start + len / 2;
       double median;
       if (len % 2 == 0) {
           median = (nums[mid] + nums[mid - 1]) / 2.0;
       } else {
           median = nums[mid];
       }
       return median;
   }
   private static double findMedianHelper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
       int len1 = end1 - start1 + 1;
       int len2 = end2 - start2 + 1;
       if (len1 <= 0 && len2 <= 0) {
            return -1;
        }
        if (len1 <= 0 && len2 > 0) {
            return findMedian(nums2, 0, len2 - 1);
        }
        if (len2 <= 0 && len1 > 0) {
            return findMedian(nums1, 0, len1 - 1);
        }
        if (len1 == 2 && len2 == 2) {
            return (Math.max(nums1[start1], nums2[start2]) + Math.min(nums1[end1], nums1[end2])) / 2.0;
        }
        if (len1 == 1 && len2 == 2) {
            if (nums1[start1] < nums2[start2]) {
                return nums2[start2];
            }
            if (nums1[start1] > nums2[end2]) {
                return nums2[end2];
            }
            return nums1[start1];
        }
        if (len1 == 2 && len2 == 1) {
            if (nums2[start2] < nums1[start1]) {
                return nums1[start1];
            }
            if (nums2[start2] > nums1[end1]) {
                return nums1[end1];
            }
            return nums2[start2];
        }
        while ((start1 <= end1) && len1 >= 2 && start2 <= end2 && len2 >= 2) {
            double median1, median2;
            median1 = findMedian(nums1, start1, end1);
            median2 = findMedian(nums2, start2, end2);
            if (median1 == median2) {
                return median1;
            }
            if (median1 > median2) {
                end1 = start1 + (end1 - start1) / 2;
                start2 = start2 + (end2 - start2) / 2;
            } else {
                start1 = start1 + (end1 - start1) / 2;
                end2 = start2 + (end2 - start2) / 2;
            }
            return findMedianHelper(nums1, start1, end1, nums2, start2, end2);
        }
       return -1;
   }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int nums1[] = {1, 12, 15, 26, 38};
//        int nums2[] = {2, 13, 17, 30, 45};
        int nums1[] = {1, 12, 15};
        int nums2[] = {2, 13};
        System.out.println("The median of nums1 & nums2 should be: 16");
        System.out.println("Median calculated: " + findMedianSortedArrays(nums1, nums2));
    }
}
/**
 * public class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        if (nums1 == null && nums2 == null) { return 0; }
        if (nums1.length == 0 && nums2.length == 0) { return 0; }
        int len = nums1.length + nums2.length;
        if (len % 2 == 0)
        {
            return (find(nums1, 0, nums2, 0, len / 2) + find(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
        else
        {
            return find(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    
    private int find(int[] nums1, int start_1, int[] nums2, int start_2, int k)
    {
        if (start_1 >= nums1.length) //第一要点：越界判断
        {
            return nums2[start_2 + k - 1];
        }
        if (start_2 >= nums2.length)
        {
            return nums1[start_1 + k - 1];
        }
        if (k == 1)  //第二要点：k == 1
        {
            return Math.min(nums1[start_1], nums2[start_2]);
        }
        int half = k / 2;
        int key_1 = Integer.MAX_VALUE;    //第三要点：越界判断，以及越界的时候用MAX_VALUE
        if (start_1 + half - 1 < nums1.length)
        {
            key_1 = nums1[start_1 + half - 1];
        }
        int key_2 = Integer.MAX_VALUE;
        if (start_2 + half - 1 < nums2.length)
        {
            key_2 = nums2[start_2 + half - 1];
        }
        if (key_1 < key_2)
        {
            return find(nums1, start_1 + half, nums2, start_2, k - half);
        }
        else
        {
            return find(nums1, start_1, nums2, start_2 + half, k - half);
        }
    }
}
 */

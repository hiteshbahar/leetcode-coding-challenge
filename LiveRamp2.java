import java.util.Arrays;
/**
 * It requires the worst time complexity is O(nlogn),
 * so I first sort the array. Arrays.sort() in java using
 * an improved quicksort so that the time complexity is O(nlogn)
 * in most cases.
 * Then I use two pointers, one is go from left to right to find the first
 * unequal elements in two arrays. The other is go from the right to left to find
 * the first elements that is unequal.
 * Elements between these two pointers are supposed to rearrange. So the final
 * result should be right - left + 1.
 * 
 * @author xinwang
 *
 */
public class LiveRamp2 {

    public static int rearrangeLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int left = 0;
        int right = n - 1;
        while ((left < n) && (arr[left] == temp[left])) {
            left++;
        }
        while ((right >= 0) && (arr[right] == temp[right])) {
            right--;
        }
        if (right > left) {
            return right - left + 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 20, 6, 4, 5};
        int[] arr2 = {1, 2, 3, 8, 7, 6, 12};
        int[] arr3 = {1, 2, 4, 3};
        int[] arr4 = {1, 2, 3, 4};
        int[] arr5 = {2, 1};
        System.out.println(rearrangeLength(arr1));
        System.out.println(rearrangeLength(arr2));
        System.out.println(rearrangeLength(arr3));
        System.out.println(rearrangeLength(arr4));
        System.out.println(rearrangeLength(arr5));
    }

}

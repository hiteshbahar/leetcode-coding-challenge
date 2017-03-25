/**
 * Since we are supposed to achieve in the time complexity
 * of O(nlogn), so we consider to use advanced sorting algorithm -- merge sort.
 * Suppose we know the number of rearrange length
 * of left half and right half of the array, the
 * total rearrange length should be composed of three parts: the number of
 * left subarray, the number of right subarray and the number
 * during merge process.
 * if a[i] in left subarray is greater than a[j] in right subarray, 
 * and because these two arrays have all been sorted, so the numbers after a[i] are 
 * all greater than a[j]. At this time, the rearrange length should be
 * mid - i (mid is the first index of the right subarray).
 * 
 * @author xinwang
 *
 */
public class MinInversions {

    public static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid;
        if (left < right) {
            mid = left + (right - left) / 2;
            return mergeSort(arr, temp, left, mid) + mergeSort(arr, temp, mid + 1, right) 
                    + merge(arr, temp, left, mid + 1, right);
        }
        return 0;
    }
    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int count = 0;
        int i = left;
        int j = mid;
        int k = left;
        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i;
            }
        }
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // copy back temp elements to original array.
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
        return count;
    }
    public static int invCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 20, 6, 4, 5};
        int[] arr2 = {1, 2, 3, 8, 7, 6, 12};
        int[] arr3 = {1, 2, 4, 3};
        System.out.println(invCount(arr1));
        System.out.println(invCount(arr2));
        System.out.println(invCount(arr3));
    }

}

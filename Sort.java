
public class Sort {
    /*merge sort is not an in place sorting algorithm for array*/
    public int[] mergeSort(int[] unsorted) {
        if (unsorted.length <= 1) {
            return unsorted;
        }
        int mid = unsorted.length / 2;
        int[] left = new int[mid];
        System.arraycopy(unsorted, 0, left, 0, mid);
        int[] right = new int[unsorted.length - mid];
        System.arraycopy(unsorted, mid, right, 0, unsorted.length - mid);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        int indexMerged = 0;
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] < right[indexRight]) {
                merged[indexMerged] = left[indexLeft];
                indexLeft++;
            } else {
                merged[indexMerged] = right[indexRight];
                indexRight++;
            }
            indexMerged++;
        }
        while (indexLeft < left.length) {
            merged[indexMerged++] = left[indexLeft++];
        }
        while (indexRight < right.length) {
            merged[indexMerged++] = right[indexRight++];
        }
        return merged;
    }
    
    /*quick sort is an in place algorithm for array*/
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    // choose the last element as pivot value.
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;    // smaller index
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                if (arr[i] == arr[j]) {
                    continue;
                }
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sort s = new Sort();
        int[] arr = new int[]{4, 9, 6, 8, 10};
        //s.quickSort(arr, 0, arr.length - 1);
        arr = s.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}


public class Sort {
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
        int[] arr = new int[]{10, 80, 30, 40, 60};
        s.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}

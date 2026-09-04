class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int low, int high) {

        // Base case
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        // Left half
        mergeSort(arr, low, mid);

        // Right half
        mergeSort(arr, mid + 1, high);

        // Merge both sorted halves
        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        // Compare both halves
        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // Remaining elements from left
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Remaining elements from right
        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy back into original array
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
}
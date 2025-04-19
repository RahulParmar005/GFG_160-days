// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum.

public class sorting23 {
    // Function to count inversions and merge two sorted halves of the array
    static int countAndMerge(int[] arr, int l, int m, int r) {
        // Calculate sizes of two subarrays
        int n1 = m - l + 1, n2 = r - m;

        // Create temporary arrays for left and right halves
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int res = 0; // To store the count of inversions
        int i = 0, j = 0, k = l;

        // Merge the two halves while counting inversions
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++]; // No inversion
            } else {
                arr[k++] = right[j++];
                res += (n1 - i); // Count inversions
            }
        }

        // Copy remaining elements of left array, if any
        while (i < n1)
            arr[k++] = left[i++];

        // Copy remaining elements of right array, if any
        while (j < n2)
            arr[k++] = right[j++];

        return res; // Return the count of inversions
    }

    // Recursive function to count inversions in the array
    static int countInv(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            // Find the middle point
            int m = (r + l) / 2;

            // Count inversions in the left half
            res += countInv(arr, l, m);

            // Count inversions in the right half
            res += countInv(arr, m + 1, r);

            // Count inversions during the merge step
            res += countAndMerge(arr, l, m, r);
        }
        return res; // Return the total count of inversions
    }

    // Wrapper function to count inversions in the entire array
    static int inversionCount(int[] arr) {
        return countInv(arr, 0, arr.length - 1);
    }

    // Main method to test the inversion count function
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5}; // Input array
        System.out.println(inversionCount(arr)); // Print the inversion count
    }
}

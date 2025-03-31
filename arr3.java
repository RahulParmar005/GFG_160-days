// You are given an array of integers arr[]. Your task is to reverse the given array.

// Note: Modify the array in place.

import java.util.Arrays;

public class arr3 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverseArray(int arr[]) {
        // code here
        int i = 0, j = arr.length-1;
        
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j]; 
            arr[j] = temp;
            i++;
            j--;
        }
    }
}




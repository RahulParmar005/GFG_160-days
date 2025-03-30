// MOVE ALL ZEROS TO THE END

// You are given an array arr[] of non-negative integers. 
// Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. 
// The operation must be performed in place, meaning you should not use extra space for another array.


import java.util.Arrays;

public class arr2 {
    public static void main(String[] args) {

        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};     // additional line 

        int count = 0; 
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }
        while(count < arr.length){
            arr[count++] = 0;
        }

        System.out.println(Arrays.toString(arr));   // additional line 
    }
}

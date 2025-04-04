// Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

// Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

public class arr5 {
    
}
class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n =arr.length;
        
        int i = n - 2;
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        
        if(i >= 0){
            int j = n - 1;
            while(arr[j] <= arr[i]){
                j--;
            }
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        reverse(arr, i+1, n-1);
        
    }
    
    static void reverse(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


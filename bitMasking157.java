// Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.

// Note: It is guaranteed that there is a repeating element present in the array.


class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        boolean[] seen = new boolean[arr.length + 1];
        for(int num : arr){
            if(seen[num]){
                return num;
            }
            seen[num] = true;

        }
        return -1;
    }    
}
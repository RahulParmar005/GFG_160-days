// You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        //  Time complexity : O(n log m);
        //  Space complexity : O(1);
        if(arr.length < k){
            return -1;
        }
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();
        int res = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(check(arr, k, mid)){
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    
    static boolean check(int arr[], int k, int pageLimit){
        int cnt = 1;
        int pageSum = 0;
        
        for(int pages : arr){
            if(pageSum + pages > pageLimit){
                cnt++;
                pageSum = pages;
            } else {
                pageSum += pages;
            }
        }
        return cnt <= k;
    }
}
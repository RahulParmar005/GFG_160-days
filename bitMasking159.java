// Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.


class Solution {
    public int findUnique(int[] arr) {
        // code here
        int res = 0;
        
        for(int num : arr) {
            res ^= num;
        }
        
        return res;
    }
}
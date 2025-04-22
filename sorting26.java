// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
import java.util.Arrays;

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;
        
       int end = intervals[0][1];
       for(int i = 1; i < intervals.length; i++){
           
           if(intervals[i][0] < end){
               count++;
               end = Math.min(intervals[i][1], end);
           } else {
               end = intervals[i][1];
           }
       }
       return count;
    }
}
// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

import java.util.ArrayList;
class Solution {
      static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
          // code here
          ArrayList<int[]> res = new ArrayList<>();
          int i = 0;
          int n = intervals.length;
          
          // add all interwals in result list that comes before newinterwal
          while(i < n && intervals[i][1] < newInterval[0]){
              res.add(intervals[i]);
              i++;
          }
          
          // merge all the overlapping elements
          while(i < n && intervals[i][0] <= newInterval[1]){
              newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
              newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
              i++;
          }   // after merging add newInterval in to result list 
          res.add(newInterval);
          
          // add remains element in result list
          while(i < n){
              res.add(intervals[i]);
              i++;
          }
          
          return res;
      }
  }
  
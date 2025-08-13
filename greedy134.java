// You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.



class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        if(n == 0) return 0;
        
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++ ) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }
        
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        
        int count  = 1;
        int j = 0;
        
        for(int i = 1; i < n; i++) {
            if(arr[i][0] > arr[j][1]) {
                count++;
                
                j = i;
            }
        }
        
        return count;
    }
}

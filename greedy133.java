// You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.

// At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.


       
// User function Template for Java

class Solution {
    static int findPlatform(int arr[], int dep[]) {  
        int n = arr.length;  
          
        // Sort arrival and departure arrays  
        Arrays.sort(arr);  
        Arrays.sort(dep);  
  
        int platformCount = 0;  
        int maxPlatforms = 0;  
  
        int i = 0; // Pointer for arrival array  
        int j = 0; // Pointer for departure array  
  
        // Traverse both arrays  
        while (i < n && j < n) {  
            // If next event in sorted order is arrival, increment count of platforms  
            if (arr[i] <= dep[j]) {  
                platformCount++;  
                i++;  
            }  
            // Else decrement count of platforms  
            else {  
                platformCount--;  
                j++;  
            }  
  
            // Update maximum platforms needed  
            maxPlatforms = Math.max(maxPlatforms, platformCount);  
        }  
  
        return maxPlatforms;  
    }  
}

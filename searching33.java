// You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int res = 0;
        int lo = 1;
        int hi = stalls[stalls.length - 1] - stalls[0];
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(check(stalls, k, mid)){
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
    
    static boolean check(int stalls[], int k, int dist){
        int cnt = 1;
        int prev = stalls[0];
        
        for(int i=0; i<stalls.length; i++){
            if(stalls[i] - prev >= dist){
                prev = stalls[i];
                cnt++;
            }
        }
        return cnt >= k;
    }
}
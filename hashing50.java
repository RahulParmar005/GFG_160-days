// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int prefXor = 0;
        
        for(int val : arr){
            prefXor ^= val;
            
            res += map.getOrDefault(prefXor ^ k, 0);
            
            if(prefXor == k){
                res++;
            }
            
            map.put(prefXor, map.getOrDefault(prefXor, 0) + 1);
        }
        
        return res;
    }
}
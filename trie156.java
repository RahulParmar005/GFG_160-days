// Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.


// User function Template for Java

class Solution {
    public int maxXor(int[] arr) {
        // code here
        int res = 0, mask = 0;
        
        HashSet<Integer> s = new HashSet<>();
        for(int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            
            for(int val : arr) {
                s.add(val & mask);
            }
            
            int cur = res | (1 << i);
            
            for(int prefix : s) {
                if(s.contains(cur ^ prefix)) {
                    res = cur;
                    break;
                }
            }
            s.clear();
        }
        
        return res;
    }
}
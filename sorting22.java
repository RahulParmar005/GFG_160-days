// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        
        // Time Complexity : O(n);
        // Space complexity : O(n);
        
        int n = citations.length;
        int freq[] = new int[n + 1];
        
        for(int i=0; i<n; i++){
            if(citations[i] >= n){
                freq[n] += 1; 
            }else{
                freq[citations[i]] += 1;
            }
        }
        
        int idx = n;
        int s = freq[n];
        
        while(s < idx){
            idx--;
            s += freq[idx];
        }
        
        return idx;
    }
}
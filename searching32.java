// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length;
        int m = b.length;
        
        int last = 0;
        int i = 0, j = 0;
        
        for(int l=0; l<k; l++){
            if(i < n){
                if(j < m && b[j] < a[i]){
                    last = b[j];
                    j++;
                } else {
                    last = a[i];
                    i++;
                }
            } else {
                last = b[j];
                j++;
            }
        }
        return last;
    }
}
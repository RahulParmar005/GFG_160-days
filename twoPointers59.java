// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 



class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left = 1;
        int right = arr.length - 2;
        
        int maxL = arr[left - 1];
        int maxR = arr[right + 1];
        
        int res = 0;
        
        while(left <= right){
            
            if(maxR <= maxL){
                res += Math.max(0, maxR - arr[right]);
                maxR = Math.max(maxR, arr[right]);
                
                right--;
            } else {
                res += Math.max(0, maxL - arr[left]);
                maxL = Math.max(maxL, arr[left]);
                
                left++;
            }
        }
        
        return res;
    }
}

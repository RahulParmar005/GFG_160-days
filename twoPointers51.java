// Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.



class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length;
        int res = 0;
        
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum < target){
                    left++;
                } else if(sum > target){
                    right--;
                } else if(sum == target){
                    int element1 = arr[left], element2 = arr[right];
                    int cnt1 = 0, cnt2 = 0;
                    
                    while(left <= right && arr[left] == element1){
                        left++;
                        cnt1++;
                    }
                    while(left <= right && arr[right] == element2){
                        right--;
                        cnt2++;
                    }
                    
                    if(element1 == element2){
                        res += (cnt1 * (cnt1 - 1)) / 2;
                    } else {
                        res += (cnt1 * cnt2);
                    }
                }
            }
        }
        return res;
    }
}
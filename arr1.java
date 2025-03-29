// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.


class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int highest = Integer.MIN_VALUE;
        int lessThanHighest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > highest) {
                lessThanHighest = highest;
                highest = num;
            } else if (num > lessThanHighest && num < highest) {
                lessThanHighest = num;
            }
        }

        if (lessThanHighest != Integer.MIN_VALUE) {
            return lessThanHighest;
        }


        return -1;
    }
}
// Binary Search method
class Solution {
    public int search(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (target == nums[pivot]) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1; 
            }
        }
        return -1;
    }
}

// Recursion methond

class Solution {
    public int search(int[] nums, int target) {
        return bsearch(nums, target, 0, nums.length - 1);
    }
    public int bsearch(int[] nums, int target, int left, int right) {
        // Exit point
        if (right < left) {
            return -1;
        }
        
        // main logic
        int pivot = left + (right - left) / 2;
        if (nums[pivot] == target) {
            return pivot;
        }
        
        // Instead of chaging the variable, chaging the input/arguments and passing it to the base function
        if (nums[pivot] > target) {
            return bsearch(nums, target, left, pivot - 1);
        } else {
            return bsearch(nums, target, pivot + 1, right);
        }
    }
}

// Time Comlexity: O(logN);
// Space Comlexity: O(1);

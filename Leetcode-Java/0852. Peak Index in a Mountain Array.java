class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int peak;
        
        while (lo < hi) {
            peak = lo + (hi - lo) / 2;
            if (arr[peak] < arr[peak + 1]) {
                lo = peak + 1;            
            } else {
                hi = peak;
        }
        return lo;
    }
}
    
// Time Complexity: O(logN), where N is the length of A.

// Space Complexity: O(1).

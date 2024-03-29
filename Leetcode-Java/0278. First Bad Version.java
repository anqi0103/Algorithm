public class Solution extends VersionControl {
    piblic int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                 right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// Time Complexity: O(logN);
// Space Complexity: O(1);

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        // If the length of the nums less than 4, return result directly
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        
        // If the smallest number times 4 is larger than target, and the largest number times 4 is smaller than target,
        // That means there is no array of unique quadruplets 
        int max = nums[nums.length - 1];
        if (nums[0] * 4 > target || max * 4 < target) {
            return res;
        }
        
        // Iterate over the array with the first pointer i and check the neighboring element is equal or not
        // If yes, continue
        for(int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Iterate over the array with the second pointer j, starting from i + 1, the next element of i
            // Check if the neighboring element of j is equal or not, if yes, continue
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Initiate the other two pointer lo and hi
                int lo = j + 1, hi = nums.length - 1;
                // While lo less than hi, compare the sum to target
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    // If sum is equal to target, add the array to the res, and check the duplicate array
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    // If sum is not equal to target, move the pointer and continue the while loop until the end of the array
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}

// Time Complexity: O(n^3) || O(n^k-1);
// Space Complexity: O(n);
// Performance improvement: 
// public class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> res = new ArrayList<>();

//         if (nums.length < 4) {
//             return res;
//         }

//         Arrays.sort(nums);

//         int max = nums[nums.length - 1];

//         if (nums[0] * 4 > target || max * 4 < target) {
//             return res;
//         }

//         for (int i = 0; i < nums.length - 3; i++) {
//             int n = nums[i];

//             if (i > 0 && n == nums[i - 1]) {
//                 continue;
//             } else if (n * 4 > target) {
//                 break;
//             } else if (n + max * 3 < target) {
//                 continue;
//             } else if (n * 4 == target) {
//                 if (nums[i + 3] == n) {
//                     res.add(Arrays.asList(n, n, n, n));
//                 }
//                 break;
//             }

//             threeSum(res, n, nums, i + 1, max, target - n);
//         }

//         return res;
//     }

//     void threeSum(List<List<Integer>> res, int a, int[] nums, int start, int max, int target) {
//         if (nums[start] * 3 > target) {
//             return;
//         }

//         for (int i = start; i < nums.length - 2; i++) {
//             int n = nums[i];

//             if (i > start && n == nums[i - 1]) {
//                 continue;
//             } else if (n * 3 > target) {
//                 break;
//             } else if (n + max * 2 < target) {
//                 continue;
//             } else if (n * 3 == target) {
//                 if (nums[i + 2] == n) {
//                     res.add(Arrays.asList(a, n, n, n));
//                 }
//                 break;
//             }

//             twoSum(res, a, n, nums, i + 1, target - n);
//         }
//     }

//     void twoSum(List<List<Integer>> res, int a, int b, int[] nums, int start, int target) {
//         int end = nums.length - 1;

//         while (start < end) {
//             int sum = nums[start] + nums[end];

//             if (sum == target) {
//                 res.add(Arrays.asList(a, b, nums[start], nums[end]));
//                 while (start < end && nums[start] == nums[start + 1]) {
//                     start++;
//                 }
//                 while (start < end && nums[end] == nums[end - 1]) {
//                     end--;
//                 }
//                 start++;
//                 end--;
//             } else if (sum < target) {
//                 while (start < end && nums[start] == nums[start + 1]) {
//                     start++;
//                 }
//                 start++;
//             } else {
//                 while (start < end && nums[end] == nums[end - 1]) {
//                     end--;
//                 }
//                 end--;
//             }
//         }
//     }
// }

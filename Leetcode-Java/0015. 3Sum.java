class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the input array nums first
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Since the solution set must not contain duplicate triplets, so we need to eliminate those edge cases
            // When the point i iterate through the array, we need to check if the neighboring element is equal or not
            // If yes, we need to move to the next element
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // We need to initiate another two pointer start and end as well
                int start = i + 1;
                int end = nums.length - 1;
                // While start less than end
                while (start < end) {
                    // We should check if there is any three element sums up equal to 0
                    int resSum = nums[i] + nums[start] + nums[end];
                    if (resSum == 0) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        // Other than check neighboring element for pointer i, I should also check that for pointer start and end
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        // Incrementing pointer start and end
                        start++;
                        end--;
                    // If the sum less than 0, pointer start plus one, otherwise, pointer end minus one
                    } else if (resSum < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }            
            }      
        }
        // return the result
        return res;
    }
}

Time complexity: O(n^2); // We have outer and inner loops, each going through n elements.
Space complexity: O(n); // Based on the implementation of the sorting algorithm.

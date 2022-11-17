// Using slow pointer j to store the element 
// Using faster pointer i to compare the element to eliminate the element which has been stored in j
// return the length of the array using index j + 1

class Solution{
    public int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        // Initiate slow pointer j
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            // Determine if the element is existed or not
            if (nums[i] != nums[j] {
                // keep moving the slow pointer
                j++;
                // Update the element
                nums[j] = nums[i];
            }
        }
        // Return the length of the array using index + 1
        return j+1;
    }
}

Time Complexity: O(n);
Splace Complexity: O(1);

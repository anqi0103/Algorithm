class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count1 = encode(s);
        int[] count2 = encode(t);

        Arrays.equals(count1, count2);
        // We could manually compare the array using for loop.
    }

    //Using frequency table to improve the time complexity to O(n)
    private int[] encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return count;
    }
}

// Follow up questions: "What if the inputs contain Unicode characters? How would you adapt your solution to such a case?"
// The solution would be replace the fixed size array with a data structure that can dynamically adjust the size based on the input characters, HashMap

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

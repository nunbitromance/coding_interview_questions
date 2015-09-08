/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public int lengthOfLongestSubstring(String s) {  
   int maxLen = 0;  
   int start = 0, end = 0;  
   // a map mapping a char to its prior index in s  
   HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
   while (end < s.length()) {  
     char cur = s.charAt(end);  
     if (map.containsKey(cur) && map.get(cur) >= start) {  
       // hit a recurrence  
       maxLen = Math.max(maxLen, end-start);  
       start = map.get(cur) + 1;  
     }  
     map.put(cur, end++);  
   }  
   maxLen = Math.max(maxLen, end-start);  
   return maxLen;  
 }  

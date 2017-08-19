/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

https://leetcode.com/problems/maximum-product-of-word-lengths/description/
*/

class Solution {
    public int maxProduct(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("words is null");
        } else if (words.length == 0) {
            return 0;
        }
        
        int[] map = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            map[i] = val;
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((map[i] & map[j]) == 0 && words[i].length() * words[j].length() > maxProduct) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
}

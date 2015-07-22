Find Anagrams

Given an array of strings, return a list of all groups of strings that are anagrams.
Note: All inputs will be in lower-case.

For example, ["tea","and","ace","ad","eat","dan"] => ["and", "dan", "tea", "eat"]
Solution

Given a set of strings, if we could mark anagrams with a same "label", then a hash tabel can help us to find out all groups of anagrams.

So, how to mark anagrams?

Intuitively, 26 bits with '1' representing existence. We need check whether the length of the two strings are the same and do some bit-magics to generate the label. The bit-magic part is tedious and error prone, the comparison would be easy though. But it won't work for the case of "aae" and "aee" since we didn't track the occurrence during labeling.

As one bit is too short for occurrences, it looks like an integer for each character would do the job. But it will be a looong label even for a short word like "eat". We can trim it by skipping non-existing characters. E.g. "and" => "a1d1n1", "array" => "a2r2y1". Also notice that we need to keep character alphabetically in the label so as to ensure that anagrams are marked with a same label.

1:    public ArrayList<String> anagrams(String[] strs) {  
2:      HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();  
3:      for (String str : strs) {  
4:        // create unique label for each string  
5:        String key = generalLabel(str);  
6:        // map the label to a list of anagrams  
7:        ArrayList<String> res = hash.get(key);  
8:        if (res==null) {  
9:          res = new ArrayList<String>();  
10:          hash.put(key, res);  
11:        }  
12:        res.add(str);  
13:      }  
14:      ArrayList<String> resSet = new ArrayList<String>();  
15:      for (ArrayList<String> anagram : hash.values()) {  
16:        // ignore strings without anagrams  
17:        if (anagram.size()>1) resSet.addAll(anagram);  
18:      }  
19:      return resSet;  
20:    }  
21:    
22:    /*  
23:     * create a unique label for a string  
24:     * "cat", "atc" => a1c1t1  
25:     */  
26:    public String generalLabel(String str) {  
27:      int[] hash = new int[26];  
28:      for (int i=0; i<str.length(); ++i) {  
29:        int index = (int)(str.charAt(i) - 'a');  
30:        hash[index]++;  
31:      }  
32:      StringBuilder ss = new StringBuilder();  
33:      for (int i=0; i<26; ++i) {  
34:        if (hash[i]==0) continue;  
35:        char c = (char)('a' + i);  
36:        ss.append(c);  
37:        ss.append(hash[i]);  
38:      }  
39:      return ss.toString();  
40:    }  

Analysis

This algorithm runs in time O(n) and uses O(n) space.

We need to general label for each string, so, that step (line 5 and 26-40) takes time O(kn) where k is the average length of strings and n is the number of strings. The mapping step takes time O(n), assuming the hash function is good (since our labels are designed to be unique for non-anagram strings, there is no collision in this case). In the last step, we go through the hash values, but each string will be touched once, and thus, the running time for the step is still O(n).

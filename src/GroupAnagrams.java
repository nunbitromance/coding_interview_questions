Find Anagrams

Given an array of strings, return a list of all groups of strings that are anagrams.
Note: All inputs will be in lower-case.

For example, ["tea","and","ace","ad","eat","dan"] => ["and", "dan", "tea", "eat"]
Solution

Given a set of strings, if we could mark anagrams with a same "label", then a hash tabel can help us to find out all groups of anagrams.

So, how to mark anagrams?

Intuitively, 26 bits with '1' representing existence. We need check whether the length of the two strings are the same and do some bit-magics to generate the label. The bit-magic part is tedious and error prone, the comparison would be easy though. But it won't work for the case of "aae" and "aee" since we didn't track the occurrence during labeling.

As one bit is too short for occurrences, it looks like an integer for each character would do the job. But it will be a looong label even for a short word like "eat". We can trim it by skipping non-existing characters. E.g. "and" => "a1d1n1", "array" => "a2r2y1". Also notice that we need to keep character alphabetically in the label so as to ensure that anagrams are marked with a same label.

  public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();
        for (String s : strs) {
            
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String t = new String(cArr);
            if (map.containsKey(t)) {
                List<String> anagrams = map.get(t);
                anagrams.add(s);
            } else {
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(s);
                map.put(t, anagrams);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() > 1) {
                result.addAll(value);
            }
        }
        
        return result;
    }
}

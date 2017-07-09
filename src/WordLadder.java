/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.*/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        Queue<Integer> ladderLength = new LinkedList<Integer>();
        queue.offer(start);
        set.add(start);
        ladderLength.offer(0);
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            Integer l = ladderLength.poll();
            set.add(cur);
            if (cur.equals(end)) {
                return l;
            }
         
            for (String s : getOneEditWords(cur, dict)) {
                if (set.contains(s)) {
                    continue;
                } else {
                    queue.add(s);
                    ladderLength.offer(l + 1);
                }
            }
        }
        
        return 0;
    }
    
    public List<String> getOneEditWords(String s, Set<String> dict) {
        List<String> oneEditWords = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            char[] cArr = s.toCharArray();
            for (char a = 'a'; a <= 'z'; a++) {
                cArr[i] = a;
                String cToS = new String(cArr);
                if (dict.contains(cToS)) {
                    oneEditWords.add(cToS);
                }
            }
        }
        return oneEditWords;
    }
}

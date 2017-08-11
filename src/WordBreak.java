/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

public class WordBreak {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        
        System.out.println(new WordBreak().wordBreakDP(str, dictionary));
        System.out.println(new WordBreak().wordBreakRecursive(str, dictionary, new HashMap<String, String>()));
    }

    public String wordBreakRecursive(String input, Set<String> dict, Map<String, String> memo) {
        // validation
        if (input.equals("")) {
            return "";
        }
        
        if (memo.containsKey(input)) {
            System.out.println("memo is hit for input: " + input);
            return memo.get(input);
        }
        
        for (int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            
            if (dict.contains(prefix)) {
                String suffix = wordBreakRecursive(input.substring(i), dict, memo);
                
                if (suffix != null) {
                    memo.put(input, prefix + " " + suffix);
                    return prefix + " " + suffix;
                }
            }
        }
        
        return null;
    }
    
    // Returns true if string can be segmented into space separated
    // words, otherwise returns false
    public bool wordBreak(string str)
    {
        int size = str.size();
        if (size == 0)   return true;

        // Create the DP table to store results of subroblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        bool wb[size+1];
        memset(wb, 0, sizeof(wb)); // Initialize all values as false.

        for (int i=1; i<=size; i++)
        {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (wb[i] == false && dictionaryContains( str.substr(0, i) ))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true)
            {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dictionaryContains( str.substr(i, j-i) ))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

        /* Uncomment these lines to print DP table "wb[]"
         for (int i = 1; i <= size; i++)
            cout << " " << wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }
    
    // Not sure...
    public String wordBreakDP(String word, Set<String> dict) {
        int[][] opt = new int[word.length()][word.length()];
        
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                opt[i][j] = -1;
            }
        }
        
        for (int l = 1; l <= word.length(); l++) {
            for (int i = 0; i < word.length() - l + 1; i++) {
                int j = i + l - 1;
                String suffix = word.substring(i, j + 1);
                if (dict.contains(suffix)) {
                    opt[i][j] = i;
                    continue;
                }
                for (int k = i + 1; k <= j; k++) {
                    if (opt[i][k-1] != -1 && opt[k][j] != -1) {
                        opt[i][j] = k;
                        break;
                    }
                }
            }
        }
        
        if (opt[0][word.length() - 1] == -1) {
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        int i = 0; int j = word.length() - 1;
        while (i < j) {
            int k = opt[i][j];
            if (i == k) {
                sb.append(word.substring(i, j + 1));
                break;
            }
            sb.append(word.substring(i, k));
            sb.append(" ");
            i = k;
        }
        return sb.toString();
    }
}

/*
Dynamic Programming | Set 17 (Palindrome Partitioning)
June 17, 2012
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. 
For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. 
Determine the fewest cuts needed for palindrome partitioning of a given string. 
For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. 
If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, 
then minimum n-1 cuts are needed.

Solution
This problem is a variation of Matrix Chain Multiplication problem. If the string is palindrome, then we simply return 0. 
Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, 
recursively calculate the cost for each cut and return the minimum value.

Let the given string be str and minPalPartion() be the function that returns the fewest cuts needed for palindrome partitioning. 
following is the optimal substructure property.

// i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.

// If none of the above conditions is true, then minPalPartion(str, i, j) can be 
// calculated recursively using the following formula.
minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 +
                                 minPalPartion(str, k+1, j) } 
                           where k varies from i to j-1
*/
   /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * https://leetcode.com/problems/palindrome-partitioning-ii/
     */
    public int minCut(String str){
        if (str.length() == 0) {
            return 0;
        }

        int[] cut = new int[str.length()];
        boolean isPal[][] = new boolean[str.length()][str.length()];
        for (int i = 1; i < str.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                    isPal[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
            }
            cut[i] = min;
        }
        return cut[str.length() - 1];
    }

public static List<String> palindromePartitioning(String s) {
 
	List<String> result = new ArrayList<String>();
 
	if (s == null)
		return result;
 
	if (s.length() <= 1) {
		result.add(s);
		return result;
	}
 
	int length = s.length();
 
	int[][] table = new int[length][length];
 
	// l is length, i is index of left boundary, j is index of right boundary
	for (int l = 1; l <= length; l++) {
		for (int i = 0; i <= length - l; i++) {
			int j = i + l - 1;
			if (s.charAt(i) == s.charAt(j)) {
				if (l == 1 || l == 2) {
					table[i][j] = 1;
				} else {
					table[i][j] = table[i + 1][j - 1];
				}
				if (table[i][j] == 1) {
					result.add(s.substring(i, j + 1));
				}
			} else {
				table[i][j] = 0;
			}
		}
	}
 
	return result;
}

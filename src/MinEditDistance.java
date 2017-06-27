/*
Continuing further on dynamic programming series, edit distance is an interesting algorithm.

Problem: Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost. 
Find minimum number of edits (operations) required to convert one string into another.
*/
public static int GetMinEditDistance(string s, string t, int R, int I, int D)
{
	int[][] minEdit = new int[s.length][t.length];
	
	// intialization
	minEdit[0][0] = 0;
	if (s.length == 0)
	{
		for (int j = 0; j < t.length; t++)
		{
			// insert all characters in t to match.
			minEdit[0][j] = j * I;
		}
	}
	if (t.length == 0)
	{
		for (int j = 0; j < s.length; t++)
		{
			// delete all characters in s to match.
			minEdit[j][0] = j * D;
		}
	}
	
	
	for (int i = 1; i < s.length; i++)
	{
		for (int j = 1; j < t.length; j++)
		{
			if (s[i] == t[j])
			{
				// same edit distance as no change needed.
				minEdit[i][j] = minEdit[i-1][j-1];
			}
			else
			{
				// E(i, j) = min( [E(i-1, j) + D], [E(i, j-1) + I],  [E(i-1, j-1) + R if i,j characters are not same] )
				int minEditDistance = Math.Min(
					minEdit[i-1][j] + D,
					minEdit[i][j-1] + I);
				minEditDistance = Math.Min(
					minEditDistance,
					minEdit[i-1][j-1] + R);
			}
		}
	}
	
	return minEdit[s.length-1][t.length-1];
}

package com.interview.dynamic;

import java.util.List;

/**
 * Date 07/07/2014
 * @author Tushar Roy
 *
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 */
public class EditDistance {

    /**
     * Uses recursion to find minimum edits
     */
    public int recEditDistance(char[]  str1, char str2[], int len1,int len2){
        
        if(len1 == str1.length){
            return str2.length - len2;
        }
        if(len2 == str2.length){
            return str1.length - len1;
        }
        return min(recEditDistance(str1, str2, len1 + 1, len2 + 1) + str1[len1] == str2[len2] ? 0 : 1, recEditDistance(str1, str2, len1, len2 + 1) + 1, recEditDistance(str1, str2, len1 + 1, len2) + 1);
    }
    
    /**
     * Uses bottom up DP to find the edit distance
     */
    public int dynamicEditDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        printActualEdits(temp, str1, str2);
        return temp[str1.length][str2.length];
        
    }

    /**
     * Prints the actual edits which needs to be done.
     */
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static void main(String args[]){
        String str1 = "azced";
        String str2 = "abcdef";
        EditDistance editDistance = new EditDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }

}

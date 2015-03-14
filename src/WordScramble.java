/*
Word SearchApr 18 '12
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
» Solve this problem
*/
public static bool FindWord(List<string> words, string target, int row, int col)
{
	for (int i = 0; i < words.Length; i++)
	{
		for (int j = 0; j < words[0].Length; j++)
		{
			bool[][] checked = new bool[words.Length][words[0].Length];
			if (FindWordAtRowCol(words, checked, target, "", i, j))
			{
				return true;
			}
		}
	}
	return false;
}

private static bool FindWordAtRowCol(List<string> words, bool[][] checked, string target, string w, int row, int col)
{
	if (row < 0 || col < 0 || row >= words.Length || col >= words[0].Length)
	{
		return false;
	}
	
	if (checked[row][col] == true)
	{
		// prevent return to already checked path.
		return false;
	}
	checked[row][col] = true;
	
	w = w + words[row][col];
	if (w.Equals(target))
	{
		return true;
	}
	
	return FindWordAtRowCol(words, checked, target, w, row - 1, col) || 
	FindWordAtRowCol(words, checked, target, w, row, col + 1) || 
	FindWordAtRowCol(words, checked, target, w, row - 1, col) || 
	FindWordAtRowCol(words, checked, chctarget, w, row, col -1);
}
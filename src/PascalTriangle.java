/*
	Pascal's TriangleOct 28 '12
	Given numRows, generate the first numRows of Pascal's triangle.
	
	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
*/
public static void PrintPascalTriangle(int k)
{
	List<int> curLevel = new List<int>();
	curLevel.Add(1);
	Print(curLevel);
	for (int i = 1; i < k; i++)
	{
		List<int> newLevel = new List<int>();
		newLevel.Add(1);
		for (int j = 1; j < i; j++)
		{
			newLevel.Add(curLevel[j-1] + curLevel[j]);
		}
		newLevel.Add(1);
		Print(newLevel);
		curLevel = newLevel;
	}
}
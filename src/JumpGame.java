/*
Jump GameMar 25 '12
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public static bool JumpGame(int[] m)
{
	for (int i = 0; i < m.Length; i++)
	{
		i = i + m[i];
	}
	
	return i >= m.Length;
}

/*
Jump Game IIMar 17 '12
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
public static int JumpGame2(int[] m, int i, int numOfJumps)
{
	if (i >= m.Length)
	{
		return numOfJumps;
	}
	
	int maxJump = m[i];
	int minJump = int.MaxValue;
	for (int j = 1; j <= maxJump; j++)
	{
		minJump = Math.Min(JumpGame2(m, i + j, numOfJumps + 1));
	}
	
	return minJump;
}

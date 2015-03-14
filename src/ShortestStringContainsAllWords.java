public static string FindMinWords(string[] text, string[] words)
{
	int minLength = 0;
	int[] wordsIndices = new int[words.Length];
	int start = 0;
	int end = 0;
	
	for (int i = 0; i < text.Length; i++)
	{
		string word = text[i];
		if (word is any of words)
		{
			wordsIndices[index] = i;
			if (minLength > minDiff[wodsIndices])
			{
				minLenghth = minDiff[wordsIndices];
				start = min;
				end = max;
			}
		}
	}
	
	return text.Substring(min, max);	
}
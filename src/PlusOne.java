/*
Plus OneApr 2 '12
Given a number represented as an array of digits, plus one to the number.
*/
public static void PlusOne(int[] m)
{
	int carry = 0;
	for (int i = m.Length - 1; i >= 0; i--)
	{
		int value = m[i] + carry;
		
		carry = value / 10;
		value = value % 10;
		
		m[i] = value;
	}
	
	if (carry > 0)
	{
		// Need to copy into bigger array.
		int[] mNew = new int[m.Length + 1];
		Array.Copy(m, mNew, 1, m.Length);
		mNew[0] = carry;
	}
}
// Given a phone number return all valid string representations
// char[] GetChar(int digit);

public static void getPhoneNumbers(int[] phoneNumber)
{
	getPhoneNumbers(phoneNumber, new char[phoneNumber.length], 0);	
}

private static void getPhoneNumbers(int[] phoneNumber, char[] phoneChars, int index)
{
	if (index == phoneChars.length)
	{
		print(phoneChars);
	}
	
	foreach (char c in GetChars(phoneNumber[index]))
	{
		phoneChars[index] = c;
		getPhoneNumbers(phoneNumber, phoneChars, index + 1);
	}
}

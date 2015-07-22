/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        String s = "";
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int val = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            s = (val % 2) + s;
            carry = (val >= 2) ? 1 : 0; 
            i--;
            j--;
        }
        while (i >= 0) {
            int val = (a.charAt(i) - '0') + carry;
            s = (val % 2) + s;
            carry = (val >= 2) ? 1 : 0; 
            i--;
        }
        while (j >= 0) {
            int val = (b.charAt(j) - '0') + carry;
            s = (val % 2) + s;
            carry = (val >= 2) ? 1 : 0; 
            j--;
        }
        
        if (carry > 0) {
            s = (carry % 2) + s;
        }
        
        return s;
    }
}

/*
Add BinaryApr 2 '12
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public static string AddBinaryNumbers(string s, string t)
{
	int sVal = ConvertBinaryToDecimal(s);
	int tVal = ConvertBinarytoDecimal(t);
	
	int result = sVal + tVal;
	return ConvertDecimalToBinary(result);
}

private static int ConvertBinaryToDecimal(string s)
{
	int val = 0;
	
	for (int i = 0; i < s.Length; i++)
	{
		val = val * 2 + (s[i] - '0'); 
	}
	
	return val;
}

private static string ConvertDecimalToBinary(int v)
{
	StringBuilder sb = new StringBuilder();
	
	while (v > 0)
	{
		char c = (v & 1) + '0';
		sb.AppendToBeginning(c);
		v = v >> 1;
	}
	
	return sb.ToString();
}

/*

Restore IP AddressesAug 8 '12
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

*/
// Call it like RestoreIP("25525511135", 0, "")

public static void RestoreIP(string s, int index, string c)
{
	if (index == s.Length)
	{
		Print(c);
	}
	
	int dig = 0;
	for (int i = 0; i < 3; i++)
	{
		dig = dig * 10 + (s[i] - '0');
		
		if (dig > 0 && dig < 255)
		{
			PrintAllIp(s, index + i + 1, c + s[i] + ".");
		}
	}
}

public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restoreIpAddresses(s, 0, "", result);
        return result;
    }
    
    private void restoreIpAddresses(String s, int segIndex, String curS, List<String> result) {
        if (segIndex == 4 && s.equals("")) {
            result.add(curS);
            return;
        } else if (segIndex <= 3) {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i) {
                    int cur = Integer.parseInt(s.substring(0, i));
                    if (cur <= 255) {
                       if (segIndex > 0) {
                           restoreIpAddresses(s.substring(i, s.length()), segIndex + 1, new StringBuilder(curS).append('.').append(cur).toString(), result);
                       } else {
                           restoreIpAddresses(s.substring(i, s.length()), segIndex + 1, new StringBuilder(curS).append(cur).toString(), result);
                       }
                    }
                }
            }
        }
    }

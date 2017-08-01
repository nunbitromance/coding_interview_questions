class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
}

/*Function to reverse words*/
public void reverse(char[] s) {
	// validate
	reverse(s, 0, s.length - 1);
	
	int b = 0;
	int e = 0;
	while (e <= s.length) {
		if (s[e] == ' ' || e == s.length) {
			reverse(s, b, e - 1);
			b = e + 1;
		}
		e++;
	}
}

private void reverse(char[] s, int b, int e) {
	while (b < e) {
		char c = s[b];
		s[b] = s[e];
		s[e] = c;
	}
}

void reverseWords(char *s)
{
  char *word_begin = s;
  char *temp = s; /* temp is for word boundry */
 
  /*STEP 1 of the above algorithm */
  while( *temp )
  {
    temp++;
    if (*temp == '\0')
    {
      reverse(word_begin, temp-1);
    }
    else if(*temp == ' ')
    {
      reverse(word_begin, temp-1);
      word_begin = temp+1;
    }
  } /* End of while */
 
   /*STEP 2 of the above algorithm */
  reverse(s, temp-1);
}

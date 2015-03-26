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

private static void reverse(char[] buf, int start, int end) {
    for (int i = start, j = end - 1; i < j; i++, j--) {
        char swap = buf[i];
        buf[i] = buf[j];
        buf[j] = swap;
    }
}

public static String reverseWords1(String sentence) {
    char[] buf = sentence.toCharArray();

    // Reverse the string, character-wise
    reverse(buf, 0, buf.length);

    // Within each word, reverse the characters again
    int wordEnd = 0;
    for (int wordStart = 0; wordStart < buf.length; wordStart = wordEnd + 1) {
        for (wordEnd = wordStart; wordEnd < buf.length && buf[wordEnd] != ' '; wordEnd++) {}

        // wordStart is at the start of a word.
        // wordEnd is just past the end of the word.
        reverse(buf, wordStart, wordEnd);
    }
    return new String(buf);
}

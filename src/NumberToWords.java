private static final String[] ones = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
private static final String[] tens = ["", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"];
private static final String[] teens = ["", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"];

public void numToString(int num) {
	StringBuilder sb = new StringBuilder();
	if (num > 1000000000) {
		sb.append(toNumber(num / 1000000000));
		sb.append(" billion ");
		num %= 1000000000;
	}

	if (num > 1000000) {
		sb.append(toNumber(num / 1000000));
		sb.append(" million ");
		num %= 1000000;
	}

	if (num > 1000) {
		sb.append(toNumber(num / 1000));
		sb.append(" thousand ");
		num %= 1000;
	}

	if (num > 100) {
		sb.append(toNumberLessThanHundred(num / 100));
		sb.append(" hundred ");
		num %= 100;
	}

	if (num > 0) {
		sb.append(toNumberLessThanHundred(num));
	}
	
	return sb.toString();
}

// 95 => "ninety five"
private String toNumberLessThanHundred(int num) {
	StringBuilder sb = new StringBuilder();
	if (num > 10 && num < 20) {
		sb.append(teens[num - 10]);
		sb.append(" ");
		return sb.toString();
	}
	if (num >= 10) {
		sb.append(tens[num / 10]);
		sb.append(" ");
		num %= 10;
	}
	if (num > 0) {
		sb.append(ones[num]);
		sb.append(" ");
	}
	return sb.toString();
}

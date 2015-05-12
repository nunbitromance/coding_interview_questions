public String convert(int n, int base) {

	boolean isNeg = false;
	if (n < 0) {
		isNeg = true;
		n *= -1;
	}

	StringBuilder result = new StringBuilder();

	while (n > 0) {
		int m = n % base;
		result.append('0' + m); 
		n = n / base;
	}

	if (isNeg) {
		result.append('-');
	}

	String t = result.reverse();
	return t;
}

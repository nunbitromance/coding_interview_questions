
/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

 String[] NUM = new String[num.length];
 
    for (int i = 0; i <num.length; i++) {
        NUM[i] = String.valueOf(num[i]);
    }
 
    java.util.Arrays.sort(NUM, new java.util.Comparator<String>() {
        public int compare(String left, String right) {
            String leftRight = left.concat(right);
            String rightLeft = right.concat(left);
            return rightLeft.compareTo(leftRight);
        }
    });
 
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < NUM.length; i++) {
        sb.append(NUM[i]);
    }
 
    java.math.BigInteger result = new java.math.BigInteger(sb.toString());
    return result.toString();

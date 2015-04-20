
public int getGcd(int a, int b) {
  for (int i=Math.min(a,b); i>=1; i--)
  if (a%i==0 && b%i==0)
    return i;
  }
}

Although this method is fast enough for most applications, there is a faster method called Euclid’s algorithm. Euclid’s algorithm iterates over the two numbers until a remainder of 0 is found. For example, suppose we want to find the GCD of 2336 and 1314. We begin by expressing the larger number (2336) in terms of the smaller number (1314) plus a remainder:

2336 = 1314 x 1 + 1022
We now do the same with 1314 and 1022:

1314 = 1022 x 1 + 292
We continue this process until we reach a remainder of 0:

1022 = 292 x 3 + 146
292 = 146 x 2 + 0
The last non-zero remainder is the GCD. So the GCD of 2336 and 1314 is 146. This algorithm can be easily coded as a recursive function:

//assume that a and b cannot both be 0
public int GCD(int a, int b)
{
   if (b==0) return a;
   return GCD(b,a%b);
}

public int LCM(int a, int b)
{
   return b*a/GCD(a,b);
}

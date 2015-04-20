
public int getGcd(int a, int b) {
  for (int i=Math.min(a,b); i>=1; i--)
  if (a%i==0 && b%i==0)
    return i;
  }
}

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

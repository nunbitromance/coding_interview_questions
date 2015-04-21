public boolean[] sieve(int n)
{
   boolean[] prime=new boolean[n+1];
   Arrays.fill(prime,true);
   prime[0]=false;
   prime[1]=false;
   int m=Math.sqrt(n);

   for (int i=2; i<=m; i++)
      if (prime[i]) {
         for (int j=2; i*j<=n; j++) {
            prime[i*j]=false;
         }
      }
   return prime;
} 

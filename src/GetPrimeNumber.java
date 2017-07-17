find the next prime number after n

public int getPrime(int n) {
  int target = n;
  boolean foundPrime = false;
  while (!foundPrime) {
    target = target + 1;
    int sqrt = Math.sqrt(target);
    boolean quit = false;
    for (int i = 2; i < sqrt; i++) {
      if (target % i == 0) {
        quit = true;
        break;
      }
    }
    if (!quit) {
      foundPrime = true;
    }
  }
  return target;
}

//checks whether an int is prime or not.
boolean isPrime(int n) {
    for(int i=2;2*i<n;i++) {
        if(n%i==0)
            return false;
    }
    return true;
}

import java.util.Arrays;
//global array just to keep track of it in this example,
//but you can easily do this within another function.

// will contain true or false values for the first 10,000 integers
boolean[] primes=new boolean[10000];
//set up the primesieve
public void fillSieve() {
    Arrays.fill(primes,true);        // assume all integers are prime.
    primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
    for (int i=2;i<primes.length;i++) {
        //if the number is prime,
        //then go through all its multiples and make their values false.
        if(primes[i]) {
            for (int j=2;i*j<primes.length;j++) {
                primes[i*j]=false;
            }
        }
    }
}

public boolean isPrime(int n) {
    return primes[n]; //simple, huh?
}

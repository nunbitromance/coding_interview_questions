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

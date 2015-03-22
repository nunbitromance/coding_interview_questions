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

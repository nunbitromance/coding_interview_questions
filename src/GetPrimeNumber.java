find the next prime number after n

public int getPrime(int n) {
  int target = n;
  while (true) {
    target = target + 1;
    int sqrt = Math.sqrt(target);
    for (int i = 2; i < sqrt; i++) {
      if (target % i == 0) {
        break;
      }
    }
    return target;
  }
  return target;
}

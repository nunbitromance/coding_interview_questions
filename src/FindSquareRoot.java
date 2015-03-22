public double sqrt(double x) {
  double lo = 0;
  double hi = x;
  double eps = 0.000001;
  
  while (lo < hi) {
    double mid = (lo + hi) / 2;
    if (mid * mid >= x - eps && mid * mid <= x + eps) {
      return mid;
    } else if (mid * mid >= x - eps) {
      hi = mid;
    } else {
      low = mid;
    }
  }
  
  return -1.0;
}

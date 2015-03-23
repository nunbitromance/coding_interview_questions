public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        
        double pow2 = 0; 
        if (n < 0) {
            n *= -1;
            pow2 = 1/(pow(x, n / 2));
            
            if (n % 2 == 0) {
                return pow2 * pow2;
            } else {
                return pow2 * pow2 * 1/x;
            }
        } else {
            pow2 = pow(x, n / 2);
            
            if (n % 2 == 0) {
                return pow2 * pow2;
            } else {
                return pow2 * pow2 * x;
            }
        }
        
    }

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    class Q_MathFunctions
    {
        public static double sqrt(double x)
        {
            if (x == 0)
            {
                return 0;
            }
            else if (x < 0)
            {
                throw new ArgumentException("x is negative");
            }

            return sqrt(x, 0, x);
        }

        private static double sqrt(double x, double begin, double end)
        {
            if (end < begin)
            {
                throw new ArgumentException("cannot find sqrt");
            }

            double mid = (begin + end) / 2;
            double epsilon = 0.1;
            double c = mid * mid;

            if (c > x - epsilon && c < x + epsilon)
            {
                return mid;
            }
            else if (c > x)
            {
                return sqrt(x, begin, mid);
            }
            else
            {
                return sqrt(x, mid, end);
            }
        }

        /// <summary>
        /// Negate + -> -, or - => +
        /// </summary>
        /// <param name="a"></param>
        /// <returns></returns>
        public static int negate(int a)
        {
            int j = 0;
            for (int i = 0; i < Math.Abs(a); i++)
            {
                if (a < 0)
                {
                    j++;
                }
                else
                {
                    j--;
                }
            }

            return j;
        }

        /// <summary>
        /// subtract(a, b) => a + negate(b)
        /// </summary>
        /// <param name="a"></param>
        /// <param name="b"></param>
        /// <returns></returns>
        public static int subtract(int a, int b)
        {
            return a + negate(b);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="a"></param>
        /// <param name="b"></param>
        /// <returns></returns>
        public static int multiply(int a, int b)
        {
            int r = 0;
            for (int i = 0; i < b; i++)
            {
                r += a;
            }
            return r;
        }


        /// <summary>
        /// power of a to b
        /// </summary>
        /// <param name="a"></param>
        /// <param name="b"></param>
        /// <returns></returns>
        public static int power(int a, int b)
        {
            if (b == 1)
            {
                return a;
            }
            else if (b == 0)
            {
                return 1;
            }

            int d = power(a, b / 2);

            if (b % 2 == 0)
            {
                return d * d;
            }
            else
            {
                return d * d * a;
            }
        }

        public static int divide(int a, int b)
        {
            int x = 0;
            int sum = 0;

            while (sum < a)
            {
                sum += b;
                x++;
            }

            return x;
        }
        
        public static int log(int a)
        {
        	int r = 0;
        	
        	while (a > 0)
        	{
        		a >>= 1;
        		r++;
        	}
        	
        	return r - 1;
        }

        /*
        public static void Main(string[] args)
        {
            Console.WriteLine("sqrt(9) -> " + sqrt(9));
            Console.WriteLine("sqrt(10) -> " + sqrt(10));
            Console.WriteLine("sqrt(16) -> " + sqrt(16));

            Console.WriteLine("negate(1) -> " + negate(1));
            Console.WriteLine("negate(9) -> " + negate(9));
            Console.WriteLine("negate(-1) -> " + negate(-1));

            Console.WriteLine("subtract(1, 1) -> " + subtract(1, 1));
            Console.WriteLine("subtract(9, 4) -> " + subtract(9, 4));
            Console.WriteLine("subtract(-1, 3) -> " + subtract(-1, 3));

            Console.WriteLine("multiply(1, 1) -> " + multiply(1, 1));
            Console.WriteLine("multiply(9, 4) -> " + multiply(9, 4));
            Console.WriteLine("multiply(-1, 3) -> " + multiply(-1, 3));

            Console.WriteLine("power(2, 1) -> " + power(2, 1));
            Console.WriteLine("power(9, 4) -> " + power(9, 4));
            Console.WriteLine("power(-1, 3) -> " + power(-1, 3));

            Console.WriteLine("divide(4, 2) -> " + divide(4, 2));
            Console.WriteLine("divide(9, 3) -> " + divide(9, 3));
            Console.WriteLine("divide(10, 3) -> " + divide(10, 3));

            Console.ReadLine();
        }*/
    }
}

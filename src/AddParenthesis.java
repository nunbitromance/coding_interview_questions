using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication3
{
    public class Q9_6_AddParenthesis
    {
       /* private static void Main(string[] args)
        {
            List<string> list = new List<string>();
            AddParen(list, 3, 3, new char[6], 0);
            Console.ReadLine();
        }*/

        public static void AddParen(List<string> list, int lCount, int rCount, char[] s, int index)
        {
            if (lCount == 0 && rCount == 0)
            {
                string str = new string(s);
                list.Add(str);
            }

            if (lCount > 0)
            {
                s[index] = '(';
                AddParen(list, lCount - 1, rCount, s, index + 1);
            }

            if (rCount > lCount)
            {
                s[index] = ')';
                AddParen(list, lCount, rCount - 1, s, index + 1);
            }
        }

        // 2nd implementation: print all possible combinations of parenthesis
        // ()()(), (())(), ((())), (()())
        public static void getParenthesis(char[] p, int lCount, int rCount, int index)
        {
        	if (lCount == 0 && rCount == 0)
        	{
        		print(p);
        	}
        	if (lCount > 0)
        	{
        		getParenthesis(p, lCount - 1, rCount, index + 1);
        	}
        	if (rCount > lCount)
        	{
        		getParenthesis(p, lCount, rCount - 1, index + 1);
        	}
        }
    }
}





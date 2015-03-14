using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    class Q_GetDepth
    {
        public static int getDepth(string s)
        {
            Stack<char> stack = new Stack<char>();
            int depth = 0;
            int index = 0;
            int maxDepth = 0;

            while (index < s.Length)
            {
                if (s[index] == '(')
                {
                    stack.Push('(');
                    depth++;
                }
                else if (s[index] == ')')
                {
                    if (stack.Peek() == '(')
                    {
                        stack.Pop();
                        depth--;

                        if (maxDepth < depth)
                        {
                            maxDepth = depth;
                        }
                    }
                }
                else if (s[index] == '0')
                {
                    if (index + 1 < s.Length && s[index + 1] == '0')
                    {
                        index++;
                    }
                }
                else
                {
                    return -1;
                }

                index++;
            }

            return maxDepth;
        }

        /*
        public static void Main(string[] args)
        {
            Console.WriteLine("(00) -> " + getDepth("(00)"));
            Console.WriteLine("((00)0) -> " + getDepth("((00)0)"));
            Console.WriteLine("((00)(00)) -> " + getDepth("((00)(00))"));
            Console.WriteLine("((00)(0(00))) -> " + getDepth("((00)(0(00)))"));
            Console.WriteLine("((00)(0(0(00)))) -> " + getDepth("((00)(0(0(00))))"));
            Console.WriteLine("x -> " + getDepth("x"));
            Console.WriteLine("0 -> " + getDepth("0"));
            Console.WriteLine("() -> " + getDepth("()"));
            Console.WriteLine("(0) -> " + getDepth("(0)"));
            Console.WriteLine("(00)x -> " + getDepth("(00)x"));
            Console.WriteLine("(0p) -> " + getDepth("(0p)"));

            Console.ReadLine();
        }*/
    }
}

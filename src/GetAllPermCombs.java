using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    class Q_GetAllPermCombs
    {
        public static List<string> GetAllPermCombs(string s)
        {
            if (string.IsNullOrEmpty(s))
            {
                return new List<string>(){""};
            }

            char c = s[0];
            List<string> rem = GetAllPermCombs(s.Substring(1));
            List<string> newRem = new List<string>();

            foreach (string t in rem)
            {
                List<string> perms = GetAllPerms(c + t);
                newRem.AddRange(perms);
            }
            rem.AddRange(newRem);

            return rem;
        }

        public static List<string> GetAllPerms(string s)
        {
            if (string.IsNullOrEmpty(s))
            {
                return new List<string>(){""};
            }
            
            char c = s[0];
            List<string> rem = GetAllPerms(s.Substring(1));
            List<string> newRem = new List<string>();
            foreach (string t in rem)
            {
                for (int i = 0; i <= t.Length; i++)
                {
                    string k = InsertCharAt(t, c, i);
                    newRem.Add(k);
                }
            }
            rem.AddRange(newRem);
            return rem;
        }

        private static string InsertCharAt(string t, char c, int i)
        {
            return t.Substring(0, i) + c + t.Substring(i);
        }

        /*
        public static void Main(string[] args)
        {
            List<string> result = GetAllPermCombs("abc");

            Console.ReadLine();
        }*/
    }
}

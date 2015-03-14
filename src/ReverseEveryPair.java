using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    public class Q_ReverseEveryPair
    {
        public class Node 
        {
            public Node(int value)
            {
                Value = value;
            }

            public int Value;
            public Node Next;
        }

        public static void ReverseEveryPair(ref Node head)
        {
            Node tmp = head.Next.Next;
            head.Next.Next = head;
            Node tmp2 = head.Next;
            head.Next = tmp;
            head = tmp2;

            Node cur = tmp;
            Node prev = head.Next;

            while (cur.Next != null)
            {
                tmp = cur.Next.Next;
                prev.Next = cur.Next;
                cur.Next.Next = cur;
                cur.Next = tmp;

                prev = cur;
                cur = tmp;
            }
        }

        public static Node ReverseEveryPairRecursive(Node head)
        {
            if (head.Next == null)
            {
               return head;
            }
            else
            {
            	Node nextPairSwapped = (head.Next != null)? null: ReverseEveryPairRecursive(head.Next.Next);
                Node tmp = head.Next;   
                if (head.Next != null)
                {
                	head.Next.Next = head;
                }                 
                head.Next = nextPairSwapped;
                return tmp;
            }
        }

        public static void Print(Node head)
        {
            Node cur = head;

            while (cur != null)
            {
                Console.Write("->" + cur.Value);
                cur = cur.Next;
            }

            Console.WriteLine();
        }

        /*
        public static void Main(string[] args)
        {
            Node e1 = new Node(1);
            Node e2 = new Node(2);
            Node e3 = new Node(3);
            Node e4 = new Node(4);
            Node e5 = new Node(5);

            e1.Next = e2;
            e2.Next = e3;
            e3.Next = e4;
            e4.Next = e5;

            Print(e1);
            //ReverseEveryPair(ref e1);
            e1 = ReverseEveryPairRecursive(e1);
            Print(e1);

            Console.ReadLine();
        }*/
    }
}

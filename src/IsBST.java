using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    public class Q_isBST
    {
        public class Node
        {
            public Node(int val)
            {
                Value = val;
            }

            public Node Left { get; set; }
            public Node Right { get; set; }
            public int Value { get; set; }
        }

        public static bool isBST(Node root, ref Node prev)
        {
            if (root == null)
            {
                return true;
            }

            if (!isBST(root.Left, ref prev))
            {
                return false;
            }

            // Process information
            if (prev != null && prev.Value > root.Value)
            {
                return false;
            }
            prev = root;

            if (!isBST(root.Right, ref prev))
            {
                return false;
            }

            return true;
        }

        public static void Main(string[] args)
        {
            Node root = new Node(4);
            root.Left = new Node(2);
            root.Right = new Node(6);
            root.Left.Left = new Node(1);
            root.Left.Right = new Node(5);

            Node prev = null;

            bool isBst = Q_isBST.isBST(root, ref prev);

            Console.ReadLine();
        }


    }
}

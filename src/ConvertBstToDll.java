/*
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

		 4
	   /  \
	  2    6
	 / \  / \
	1  3 5   7

Output:
1->2->3->4->5->6->7	  	
*/
public static Node ConvertBstToLinkedList(Node root)
{
	if (root == null)
	{
		return null;
	}
	
	Node left = ConvertBstToLinkedList(root.Left);
	Node right = ConvertBstToLinkedList(root.Right);
	
	// Link the left list's tail to root
	root.Left = left.Left;
	left.Left.Right = root;
	
	// Link the right lists' head to root
	root.Right = right;
	Node rightTail = right.Left;
	right.Left = root;
	
	// Make the list circularly linked.
	left.Left = rightTail;
	rightTail.Right = left;
	
	return left != null? left : root;
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    public class Q_ConvertBstToDll
    {
        public class Node
        {
            public Node Left {get;set;}
            public Node Right {get;set;}
            public int Value {get;set;}
        }

        public static Node convertBstToCll(Node root)
        {
            if (root == null)
            {
                return null;
            }

            Node left = convertBstToCll(root.Left);
            Node right = convertBstToCll(root.Right);

            // Join left linked list tail to current root.
            if (left != null)
            {
                if (left.Left != null)
                {
                    root.Left = left.Left;
                    left.Left.Right = root;
                }
                else
                {
                    root.Left = left;
                    left.Right = root;
                }
            }

            // Join right linked list head to current root.
            if (right != null)
            {
                root.Right = right;
                right.Left = root;
            }

            if (left != null && right != null)
            {
                // Join left and right
                left.Left = right;
                right.Right = left;
            }

            return left != null? left : root;
        }

        public static Node convertBstToDll(Node root)
        {
            Node head = convertBstToCll(root);
            head.Left.Right = null;
            head.Left = null;

            return head;
        }

        public static void Main(string[] args)
        {
            Node root1 = new Node() { Value = 1 };
            Node root2 = new Node() { Value = 2 };
            Node root3 = new Node() { Value = 3 };
            Node root4 = new Node() { Value = 4 };
            Node root5 = new Node() { Value = 5 };
            Node root6 = new Node() { Value = 6 };
            Node root7 = new Node() { Value = 7 };

            root1.Left = root2;
            root1.Right = root3;
            root2.Left = root4;
            root2.Right = root5;
            root3.Left = root6;
            root3.Right = root7;

            Node list = convertBstToDll(root1);

            Console.ReadLine();
        }
    }
}



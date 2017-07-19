package com.interview.linklist;

/**
 * Date 03/24/2016
 * @author Tushar Roy
 *
 * A linked list is given such that each node contains an additional random pointer which could point
 * to any node in the list or null. Return a deep copy of the list.
 *
 * Time complexity is O(n)
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyLinkListWIthArbitPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){ 
            return null; 
        } 
         
        Node current = head; 
        //create new node with same value as current and insert it after current 
        while(current != null){ 
            Node newNode = Node.newNode(current.data); 
            newNode.next = current.next; 
            newNode.child = current.child; 
            current.next = newNode; 
            current = newNode.next; 
        } 
        //copy arbit position of current for the copy 
        current = head; 
        while(current != null){ 
            current.next.child = current.child.next; 
            current = current.next.next; 
        } 
         
        //now separate copy from the main list 
        Node newHead = null; 
        Node newCurrent = null; 
        current = head; 
        while(current != null){ 
            if(newHead == null){ 
                newHead = current.next; 
                current.next = current.next.next; 
                newCurrent = newHead; 
            }else{ 
                newCurrent.next = current.next; 
                current.next = current.next.next; 
                newCurrent = newCurrent.next; 
            } 
            current = current.next; 
        } 
        return newHead; 
    }

    public static void main(String args[]){

        CopyLinkListWIthArbitPointer cll = new CopyLinkListWIthArbitPointer();

        RandomListNode randomListNode = new RandomListNode(-1);
        RandomListNode randomListNode1 = new RandomListNode(4);
        RandomListNode randomListNode2 = new RandomListNode(8);
        RandomListNode randomListNode3 = new RandomListNode(-3);
        RandomListNode randomListNode4 = new RandomListNode(7);
        randomListNode.next = randomListNode1;
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;

        randomListNode.random = randomListNode1;
        randomListNode2.random = randomListNode3;
        randomListNode1.random = randomListNode;
        cll.copyRandomList(randomListNode);
    }
}

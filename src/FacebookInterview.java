1. Create an addition function for two string integers.  
  // Test 1: 123 + 12 = 135
  // Test 2: 999 + 99 = 1098
  public String add(String a, String b) {
    // validate
    int c = 0;
    StringBuilder result = new StringBuidler();
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 && j >= 0) {
      int cur = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
      int d = cur % 10;
      c = cur / 10;
      result.append(d);
    }
    while (i >= 0) {
       int cur = a.charAt(i) - '0';
       int d = cur % 10;
       c = cur / 10;
       result.append(d);
    }
    while (j >= 0) {
       int cur = b.charAt(i) - '0';
       int d = cur % 10;
       c = cur / 10;
       result.append(d);
    }
    if (c > 0) {
      result.append(c);
    }
    return result.reverse();
  }
  
2. Search for an item in a sorted, but rotated, array
  [4, 5, 6, 1, 2, 3]
  public int findInSortedArray(int[] arr, int t, int s, int e) {
       if (s > e) {
        return -1;
       }
       int m = s + (e - s) / 2;
       if (arr[m] == t) {
        return m;
       } else if (arr[m] > t) {
        // left half is sorted
        if (arr[m] > arr[b]) {
          return findInSortedArray(arr, t, b, m - 1);
        } else {
          return findInSortedArray(arr, t, m + 1, e);
        }
       } else { // arr[m] < t
        if (arr[m] < arr[e]) {
          return findInSortedArray(arr, t, m + 1, e); 
        } else {
          return findInSortedArray(arr, t, b, m - 1);
        }
       }
       return -1;
  }

3. reverse linked list
// eazy peazy~
  public Node reverse(Node head) {
    Node prev = null;
    Node cur = head;
    while (cur != null) {
      Node next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

4. word ladder, wildcard matching 
  public List<String> wordLadder(String start, String end, Set<String> dic) {
    Queue<String> queue = new LinkedList<>();
    List<String> path = new ArrayList<String>();
    Set<String> set = new HashSet<String>();
    path.add(start);
    queue.offer(start);
    while (!queue.isEmpty()) {
      String cur = queue.poll();
      if (cur.equals(end)) {
        path.add(cur);
        return result;
      }
      List<String> oneLetterEdits = getOneLetterEditWords(cur, dic);
      for (String w : oneLetterEdits) {
        if (!set.contains(w)) {
           queue.offer(w);
           set.add(w);
        }
      }
    }
  }
  
  private List<String> getOneLetterEditWords(String w, Set<String> dic) {
    char[] cStr = w.toCharArray();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < w.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (w.charAt(i) != c && !dic.contains(cStr)) {
          cStr[i] = c;
          result.add(new String(cStr));
        }
      }
    }
    return result;
  }

  //a*b, aab, b, => true
  // recursive approach
  public boolean isMatching(String s, String p) {
     // validation
    if (p.length() <= 1) {
      return (p.empty() && s.empty()) || s.equals(p) || p.charAt(0) == '.'; 
    }
    
    if (p.charAt(1) != '*') {
      return s.charAt(0) == p.charAt(0) && isMatching(s.subtring(1), p.substring(1)); 
    } else {
      if (isMatching(s, p.substring(2)) {
        return true;
      } else {
        int start = 0;
        while (s.charAt(start) == p.charAt(0)) {
          if (isMatching(s.substring(start), p.substring(2))) {
            return true;
          }
          start++;
        }
      }
    }
    return false;
  }

5. Given a string and a list of alphabetic letters, find the minimum length of substring that contains all the characters 
   given in O(n) time
         
   // aaabcadabc,  [a,b,c,d] => dabc
   public String minWindow(String s, String t) {
      Map<Character, Integer> tMap = new HashMap<>();
      for (char c : t.toCharArray()) {
        tMap.compute(c, (k, v) => (v == null) ? 1 : v + 1);
      }
      int start = 0;
      int end = 0;
      Map<Character, Integer> found = new HashMap<>();
      int minWindow = Integer.MAX_VALUE;
      int tFound = 0;
      while (end < s.length()) {
        char c = s.charAt(end);
        if (tMap.containsKey(c)) {
           if (found.containsKey(c)) {
              if (found.get(c) < tMap.get(c)) {
                tFound++; 
              }
              found.put(c, found.get(c) + 1);
           } else {
              found.put(c, 1); 
           }
        }
        if (tFound == t.length()) {
          char sc = s.charAt(start);
          while (start < end && (!tMap.containsKey(sc) || found.get(sc) > tMap.get(sc)) {
            if (found.containsKey(sc) && found.get(sc) > tMap.get(sc))) {
              found.put(sc, found.get(sc) - 1); 
            }
            start++;
            sc = s.charAt(start);
          }
          int window = end - start + 1;
          minWindow = Math.min(minWindow, window);
        }
        end++;
      }
   }
  
6. Convert a BST to a circular linked list  

     // 2
       1 3
          4
     // -> 1, 2, 3, 4
     public Node convertToList(Node root) {
        if (root == null) {
          return null; 
        }
        
        Node left = convertToList(root.left);
        Node right = convertToList(root.right);
       
        // link left side of root
        Node temp = left.left;
        left.left.right = root;
        root.left = temp;
       
        // link right side of root
        temp = right.left;
        root.right = right;
        right.left = root;
       
        // link left's left to right's left
        left.left = temp;
        temp.right = left;
        
        return left;
     }
                 
7. Print out a tree in column order, starting from left to right                 
8. Implement a queue using a circular buffer.  
   
   public class CircularBufferQueue<T> implements Queue<T> {
     private T[] arr;
     private int read;
     private int write;
     private int count;
     
     public CircularBufferQueue(int capacity) {
       this.arr = new T[capacity + 1];
       read = 0;
       write = 0;
       count = 0;
     }
     
     public void offer(T e) {
       arr[write] = e;
       write = (write + 1) % arr.length;
       count++;
     }
     
     public boolean isEmpty() {
       return read == write && count == 0; 
     }
     
     public T poll() {
       T e = arr[read];
       arr[read] = null;
       read++;
       read = (read + 1) % arr.length;
       count--;
       return e;
     }
   }
                 
9. Write a function that takes an integer and prints out the English text of it. ex. Input: 1432; Output: 'One thousand, four hundred thirty-two'  

private static final String[] ones = new String[] {"", "one", "two", ..., "nine"};
private static final String[] tens = new String[] {"", "ten", "twenty", ..., "ninety"};
private static final String[] teens = new String[] {"", "eleven", "twelve", ..., "nineteen"};

public String numToWords(int num) {
  StringBuilder sb = new StringBuilder();
  if (num >= 1000000) {
    sb.append(ones[num / 1000000] + " million ");
    num = num % 1000000;
  }
  if (num >= 1000) {
    sb.append(numToWoresLessThanThousand(num / 1000) + " thousand ");
    num = num % 1000;
  }
  sb.append(numToWordsLessThanThousand(num));
  return sb.toString();
}
                 
private String numToWordsLessThanThousand(int num) {
  StringBuilder sb = new StringBuilder();
  if (num >= 100) {
    sb.append(ones[num/100] + " hundred ");
    num = num % 100;
  }
  if (num > 10 && num < 20) {
    sb.append(teens[num - 10]);
    return sb.toString();
  } else if (num >= 20) {
    sb.append(tens[num] + " ");
    num = num % 10;
  }
  if (num > 0) {
    sb.append(ones[num]); 
  }
  return sb.toString();
}
                 
10. How to find all anagrams of a word given a dictionary?  
11. Write a function for testing "endianness."  
12. Write push/pop functions for a ring buffer. 
13. Given two words and a dictionary, print the path from one word to the next changing one letter at a time  
14. Given two identical DOM tree structures, A and B, and a node from A, find the corresponding node in B.  
15. Implement a sorted circular linked list.
16. Given an n*n matrix filled randomly with different colors (no limit on what the colors are), add up the total number of groups of each color - a group is adjacent cells of the same color touching each other. Clarifying question: are diagonals adjacent (A: no) 
17. Write a system to parse byte chunks of messages
18. Merge a list of (possibly overlapping) time intervals and return a sorted list of non-overlapping time intervals. 
19. How would you implement a Naive String matching program? 2) How do you know when if a binary tree is a BST?
20. Given 2 strings that you are reading from 2 streams (so you don't know the length of any of the strings and the only method you have is getNextChar() for each string), implement a program that tells you when 2 of these strings are 1 edit away from being the same. 1- edit is defined as a single insert char, single remove char or single modify/change char in only 1 of the strings.  

Flatten a JSON like structure.

Write a spreadsheet engine in the language of my choice. 

Design a price surge system, both at a high level and the architecture 

Phone screen: Fill in this function header, which is   responsible for finding all vehicle stops closest to a user's GPS location. 

On-Site: A design question (How would you design a ride-share application?) A technical communication question. A fairly simple coding question involving some OOP. A design discussion with the hiring manager. 

Using Object Oriented Design principles, design a method to check if a Sudoku board is valid (skeleton code was provided which was initially passed in through a 2-d array).

Implement boggle

Design a price surge system, both at a high level and the architecture

All the questions were open ended like how would you design netflix,online spreadsheet, tell me about a challenging situation/issue in your current/past project etc 

Implement LRU cache with get and set operations in constant time O(1). 

Given a regular expression pattern and a string, check to see if pattern matches the string. 

Design a distributed system for sorting of large files.
  
Implement an Iterator of a binary tree inorder traversal
Find the number of (islands) connected components in a 2-d array of 1s and 0s.
Implement an iterator that works with a collection of elements and collections and returns elements in order, e.g. (1, (2, 3), 4) will result in 1, 2, 3, 4
Given a list of string, return the most common strings
Implement a method that calculates the exclusive time spent on a given function name, given the call stack with entry/exit timestamps. 
Flatten a nested list and then code up an iterative interface.
Minimum spanning tree type problems
Find the sum of subarray in a 2d matrix which is closest to k.
Serializing and deserializing binary trees
Implement a ring buffer.
Insert a value into a sorted circular list given one node(any) in the circular list.
Implementing getNBytes(int N, char* buffer) from get4Bytes(char* buffer).

import java.io.*;
import java.util.*;
import java.util.Date;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


We own a chain of pizza restaurants. 

We need to build:

/timeToNextPizza/<pizza type> : returns the earliest  time that ANY location will produce that kind of pizza 



We have access to 2 endpoints (external APIs):


1.  /locations/<pizza type> : returns all locations that produce that kind of pizza



e.g.: /locations/peperroni: [TrainStation, CivicCenter]




2. /timeToNextPizza/<location>/<pizza type> : returns the next time that location will produce that kind of pizza in minutes
10:00am TrainStation peperroni: 7
10:01am                       : 6
10:07                           0
10:08                           19



e.g.:

/timeToNextPizza/TrainStation/peperroni : 7

/timeToNextPizza/CivicCenter/peperroni : 13

Coming back to the endpoint we need to expose, 
for above values:

/timeToNextPizza/peperroni : 7


 */

class CacheKey {
  String location;
  String pizzaType;
}

class CacheValue {
  public Date originalTime;
  public int min;
}

class Solution {
  
  private Map<CacheKey, CacheValue> cache = new HashMap<CacheKey, CacheValue>(); 
  
  public List<String> getLocations(String pizzaType) {
    List<String> result = new ArrayList<String>();
    result.add("TrainStation");
    result.add("CivicCenter");
    return result;
  }
  
  public Integer getNextTime(String location, String pizzaType) {
    
    if (location.equals("TrainStation")) {
      return 7;
    } else if (location.equals("CivicCenter")) {
      return 6;
    }
    return -1;
  }
  
  public Integer getNextEarliestTime(String pizzaType) {
    
    List<String> locations = getLocations(pizzaType);
    
    int minNextTime = Integer.MAX_VALUE;
    for (String location: locations) {
      
      CacheValue val = null;
      CacheKey key = new CacheKey(location, pizzaType);
      int nextTime = -1;
      if (cache.containsKey(key)) {
        val = cache.get(key);
        if ((val.min -  (new Date() - val.originalTime).minuteOfDay()) > 0) {
          nextTime = val.min -  (Date() - val.originalTime).minuteOfDay();
        }
      }
      
      if (nextTime == -1) {
        nextTime = getNextTime(location, pizzaType);
        val = new CacheValue(DateTime.now(), nextTime);
        cache.put(key, val);
      }

      minNextTime = Math.min(nextTime, minNextTime);
    }
    
    return minNextTime;
  }
  
  
  public static void main(String[] args) {
    
    Solution s = new Solution();
    int val = s.getNextEarliestTime("peperoni");
    System.out.println("earliest time" + val);
  }
}

Uber Questions

1. LRU cache
2. Find Island in matrix 
3. Create an elevator system
4. Why do you want to work at Uber?
5. stock price - best time to buy in and sell.  
6. Linked List Sum
7. Longest Palindrome
8. Rotate Matrix  
9. Give a list of number, return all subsets of the list.
10. Implement a HashTable
11. Word Break
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

12. Given input which is a vector of (user name, log-in time, log-out time), output time series which will have number of users logged in at each given time slot in the input,
 output should only contain time slots which are given in input for example if the input is
 "September", 1.2, 4.5),
("June", 3.1, 6.7),
("August", 8.9, 10.3)

output should contain only 1.2, 3.1, 4.5, 3.1, 6.7, 8.9, 10.3

Example:
/*
[
("September", 1.2, 4.5),
("June", 3.1, 6.7),
("August", 8.9, 10.3)
]

=>

[(1.2, 1), (3.1, 2), (4.5, 1), (6.7, 0), (8.9, 1), (10.3, 0)]

*/  

13. Constant time random access hash implementation

14. Efficient elevator API

15. Ransom note

16. Median of k unsorted arrays

17. Design of a task scheduler

18. Custom comparator  

19. Design an alarm system for a driverless car

20. Given an input string of numbers like 121, find all permutations of that number in the same order for the corresponding letters for each number so 121 => 1 2 1, 12 1, and 1 21 which is ABA, LA, and AT  

21. Quite simple leetcode questions like printing out a "pretty" version of a tree  

22. Given an array of Ints find a maximum sum of non adjacent elements.
for ex. arr = [1,0,3,9,2] then ans would be 10 = 1 + 9 (non adjacent element)  

23. // evalexpr(-4 - 3 * 2 / 2 + 4) -> result (float or double)
//
// [Token(NUM, -4.), Token(SUB), Token(NUM, 3), Token(MUL)…]
//
// input: an array/list of Tokens representing a VALID arithmetic expression
// output: the result as a float or double
//
// Token:
// type: one of NUM, ADD, SUB, MUL, DIV
// value: float or double it's only defined/relevant when the token as type NUM
//
// Todo:
// 1. implement the Token class/struct
// 2. implement evalexpr  

24. Implement data structure "Map" storing pairs of integers (key, value) and define following member functions in O(1) runtime: void insert(key, value), void delete(key), int get(key), int getRandomKey(). 

25. Given a string A and B, find the smallest substring of A that contains all the characters from B. (implement solution in O(n), keep in mind chars in B can repeat)  

26. Given a picture of square with a bunch of horizontal and vertical lines in it (lines are not necessarily spanning the full square length, in other words think of a fine grid with many holes in it), design data structure(s) representing the data and a function that returns a number of squares pictured. (actual implementation expected)  

27. How would you design Youtube (need for low latency, robustness against data loss, ...) (no implementation necessary)  

28. how to implement Uber pool. given two trips find and algorithm to see if they should be pooled  

29. Write a function that returns values randomly, according to their weight

30. write code for this function matchstr() given
"ab" in a(1)b(1) ---> true
"z" in a(4)b(4) --> false
"aaaa" in a(3)b(3) ---> false
"aab" in a(3)b(3) ---> true
"aaba" in a(3)b(3) ---> true

asked and he told that a(3)b(3) means {"ab","aab","aaab","aabbb"... etc.. all combinations of a dn b string lengths... b should always be after an a.
asked and he told that a(3)b(3)a(3) is also possible
asked and told that a(0)b(3)a(3)c(3) is also possible .. which means every string… 

. which means every string starts with b - This information changed my interview experience. 

31. Permutations of an Array of Arrays
Given a list of array, return a list of arrays, each array is a combination of one element in each given array.
Let me give you an example to help you understand the question Suppose the input is [[1, 2, 3], [4], [5, 6]], the output should be [[1, 4, 5], [1, 4, 6], [2, 4, 5], [2, 4, 6], [3, 4, 5], [3, 4, 6]].

  // This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

Count occurrences of a given number in a sorted array which has duplicates 0000001 1 1 1 1 2 2 2 2 2 3 3 3 3 3 4 4 4 
Given 4, you return 3

arr, target

N 

public int findCount(int[] arr, int target, int b, int e) {
    // validate
    
    if (b > e) {
        return -1;
    }
    
    int mid = b + (e - b) / 2;
    
    if (arr[mid] == target) {
        // start expanding
        int count = 1;
        int left = mid - 1;
        int right = mid + 1;
        
        while (left >= 0 && arr[left] == arr[mid]) {
            count++;
            left--;
        }
        while (right < arr.length && arr[right] == arr[mid]) {
            count++;
            right++;
        }
        return count;
    } else if (arr[mid] > target) {
        return findCount(arr, target, b, mid -1);
    }
    
    return findCount(arr, target, mid + 1, e);
}

//0 0 0 0 0 0 1 *** 1 1 1 1 && 2 2 && *** *** 2 *** 2 2 3 3 3 3 3 4 4 4 5 5 5
public int findFirstIndex(int[] arr, int target, int b, int e) {
    // validate
    
    if (b > e) {
        return -1;
    }
    
    int mid = b + (e - b) / 2;
    
    /*
    if (arr[mid] == target && arr[mid-1] < arr[mid]) {
        return mid;
    } else if (arr[mid] > target || (arr[mid] == target && arr[mid-1] == arr[mid])) {
        return findCount(arr, target, b, mid -1);
    }*/
    
    if (arr[mid] == target) {
        if (arr[mid-1] < arr[mid]) {
            return mid;
        } else { // element at mid -1 equals mid. continue finding left side. 
            return findCount(arr, target, b, mid -1);
        }
    } else if (arr[mid] > target) {
        return findCount(arr, target, b, mid -1);
    }
    return findCount(arr, target, mid + 1, e);
}

//0 0 0 0 0 0 1 *** 1 1 1 1 && 2 2 && *** *** 2 *** 2 2 3 3 3 3 3 4 4 4 5 5 5
public int findFirstIndex(int[] arr, int target, int b, int e) {
    // validate
    
    while (b <= e) {
        int mid = b + (e - b) / 2;
        if (arr[mid] == target) {
            if (mid == 0 || (mid -1 > 0 && arr[mid-1] < arr[mid])) {
                return mid;
            } else { // element at mid -1 equals mid. continue finding left side. 
                e = mid - 1;
            }
        } else if (arr[mid] > target) {
            e = mid - 1;
        }
        b = mid + 1;
    }
    
    return -1;
}

//0 0 0 0 0 0 1 *** 1 1 1 1 && 2 2 && *** *** 2 *** 2 2 3 3 3 3 3 4 4 4 5 5 5
public int findLastIndex(int[] arr, int target, int b, int e) {
    // validate
    
    while (b <= e) {
        int mid = b + (e - b) / 2;
        if (arr[mid] == target) {
            if (mid == arr.length - 1 || (mid + 1 < arr.length && arr[mid] < arr[mid + 1])) {
                return mid;
            } else { // element at mid -1 equals mid. continue finding right side. 
                b = mid + 1;
            }
        } else if (arr[mid] > target) {
            b = mid + 1;
        }
        e = mid - 1;
    }
    
    return -1;
}


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


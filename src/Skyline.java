Divide and Conquer | Set 7 (The Skyline Problem)
Given n rectangular buildings in a 2-dimensional city, computes the skyline of these buildings, eliminating hidden lines. The main task is to view buildings from a side and remove all sections that are not visible.

building

All buildings share common bottom and every building is represented by triplet (left, ht, right)

‘left': is x coordinated of left side (or wall).
‘right': is x coordinate of right side
‘ht': is height of building.

For example, the building on right side (the figure is taken from here) is represented as (1, 11, 5)

A skyline is a collection of rectangular strips. A rectangular strip is represented as a pair (left, ht) where left is x coordinate of left side of strip and ht is height of strip.

Examples:

Input: Array of buildings
       { (1,11,5), (2,6,7), (3,13,9), (12,7,16), (14,3,25),
         (19,18,22), (23,13,29), (24,4,28) }
Output: Skyline (an array of rectangular strips)
        A strip has x coordinate of left side and height 
        (1, 11), (3, 13), (9, 0), (12, 7), (16, 3), (19, 18),  
        (22, 3), (25, 0)
The below figure (taken from here) demonstrates input and output.  
The left side shows buildings and right side shows skyline.
skyline


Consider following as another example when there is only one
building
Input:  {(1, 11, 5)}
Output: (1, 11), (5, 0)
A Simple Solution is to initialize skyline or result as empty, then one by one add buildings to skyline. A building is added by first finding the overlapping strip(s). If there are no overlapping strips, the new building adds new strip(s). If overlapping strip is found, then height of the existing strip may increase. Time complexity of this solution is O(n2)

We can find Skyline in Θ(nLogn) time using Divide and Conquer. The idea is similar to Merge Sort, divide the given set of buildings in two subsets. Recursively construct skyline for two halves and finally merge the two skylines.

How to Merge two Skylines?
The idea is similar to merge of merge sort, start from first strips of two skylines, compare x coordinates. Pick the strip with smaller x coordinate and add it to result. The height of added strip is considered as maximum of current heights from skyline1 and skyline2.
Example to show working of merge:

  Height of new Strip is always obtained by takin maximum of following
     (a) Current height from skyline1, say 'h1'.  
     (b) Current height from skyline2, say 'h2'
  h1 and h2 are initialized as 0. h1 is updated when a strip from
  SkyLine1 is added to result and h2 is updated when a strip from 
  SkyLine2 is added.
 
  Skyline1 = {(1, 11),  (3, 13),  (9, 0),  (12, 7),  (16, 0)}
  Skyline2 = {(14, 3),  (19, 18), (22, 3), (23, 13),  (29, 0)}
  Result = {}
  h1 = 0, h2 = 0
 
  Compare (1, 11) and (14, 3).  Since first strip has smaller left x,
  add it to result and increment index for Skyline1. 
  h1 = 11, New Height  = max(11, 0)   
  Result =   {(1, 11)}

  Compare (3, 13) and (14, 3). Since first strip has smaller left x,
  add it to result and increment index for Skyline1
  h1 = 13, New Height =  max(13, 0)
  Result =  {(1, 11), (3, 13)}   
  
  Similarly (9, 0) and (12, 7) are added.
  h1 = 7, New Height =  max(7, 0) = 7
  Result =   {(1, 11), (3, 13), (9, 0), (12, 7)}

  Compare (16, 0) and (14, 3). Since second strip has smaller left x, 
  it is added to result.
  h2 = 3, New Height =  max(7, 3) = 7
  Result =   {(1, 11), (3, 13), (9, 0), (12, 7), (14, 7)}

  Compare (16, 0) and (19, 18). Since first strip has smaller left x, 
  it is added to result.
  h1 = 0, New Height =  max(0, 3) = 3
  Result =   {(1, 11), (3, 13), (9, 0), (12, 7), (14, 3), (16, 3)}

Since Skyline1 has no more items, all remaining items of Skyline2 
are added 
  Result =   {(1, 11), (3, 13), (9, 0), (12, 7), (14, 3), (16, 3), 
              (19, 18), (22, 3), (23, 13), (29, 0)}

One observation about above output is, the strip (16, 3) is redundant
(There is already an strip of same height). We remove all redundant 
strips. 
  Result =   {(1, 11), (3, 13), (9, 0), (12, 7), (14, 3), (19, 18), 
              (22, 3), (23, 13), (29, 0)}

In below code, redundancy is handled by not appending a strip if the 
previous strip in result has same height.
Below is C++ implementation of above idea.

// A divide and conquer based C++ program to find skyline of given
// buildings
#include<iostream>
using namespace std;
 
// A structure for building
struct Building
{
    int left;  // x coordinate of left side
    int ht;    // height
    int right; // x coordinate of right side
};
 
// A strip in skyline
class Strip
{
    int left;  // x coordinate of left side
    int ht; // height
public:
    Strip(int l=0, int h=0)
    {
        left = l;
        ht = h;
    }
    friend class SkyLine;
};
 
// Skyline:  To represent Output (An array of strips)
class SkyLine
{
    Strip *arr;   // Array of strips
    int capacity; // Capacity of strip array
    int n;   // Actual number of strips in array
public:
    ~SkyLine() {  delete[] arr;  }
    int count()  { return n;   }
 
    // A function to merge another skyline
    // to this skyline
    SkyLine* Merge(SkyLine *other);
 
    // Constructor
    SkyLine(int cap)
    {
        capacity = cap;
        arr = new Strip[cap];
        n = 0;
    }
 
    // Function to add a strip 'st' to array
    void append(Strip *st)
    {
        // Check for redundant strip, a strip is
        // redundant if it has same height or left as previous
        if (n>0 && arr[n-1].ht == st->ht)
            return;
        if (n>0 && arr[n-1].left == st->left)
        {
            arr[n-1].ht = max(arr[n-1].ht, st->ht);
            return;
        }
 
        arr[n] = *st;
        n++;
    }
 
    // A utility function to print all strips of
    // skyline
    void print()
    {
        for (int i=0; i<n; i++)
        {
            cout << " (" << arr[i].left << ", "
                 << arr[i].ht << "), ";
        }
    }
};
 
// This function returns skyline for a given array of buildings
// arr[l..h].  This function is similar to mergeSort().
SkyLine *findSkyline(Building arr[], int l, int h)
{
    if (l == h)
    {
        SkyLine *res = new SkyLine(2);
        res->append(new Strip(arr[l].left, arr[l].ht));
        res->append(new Strip(arr[l].right, 0));
        return res;
    }
 
    int mid = (l + h)/2;
 
    // Recur for left and right halves and merge the two results
    SkyLine *sl = findSkyline(arr, l, mid);
    SkyLine *sr = findSkyline(arr, mid+1, h);
    SkyLine *res = sl->Merge(sr);
 
    // To avoid memory leak
    delete sl;
    delete sr;
 
    // Return merged skyline
    return res;
}
 
// Similar to merge() in MergeSort
// This function merges another skyline 'other' to the skyline
// for which it is called.  The function returns pointer to
// the resultant skyline
SkyLine *SkyLine::Merge(SkyLine *other)
{
    // Create a resultant skyline with capacity as sum of two
    // skylines
    SkyLine *res = new SkyLine(this->n + other->n);
 
    // To store current heights of two skylines
    int h1 = 0, h2 = 0;
 
    // Indexes of strips in two skylines
    int i = 0, j = 0;
    while (i < this->n && j < other->n)
    {
        // Compare x coordinates of left sides of two
        // skylines and put the smaller one in result
        if (this->arr[i].left < other->arr[j].left)
        {
            int x1 = this->arr[i].left;
            h1 = this->arr[i].ht;
 
            // Choose height as max of two heights
            int maxh = max(h1, h2);
 
            res->append(new Strip(x1, maxh));
            i++;
        }
        else
        {
            int x2 = other->arr[j].left;
            h2 = other->arr[j].ht;
            int maxh = max(h1, h2);
            res->append(new Strip(x2, maxh));
            j++;
        }
    }
 
    // If there are strips left in this skyline or other
    // skyline
    while (i < this->n)
    {
        res->append(&arr[i]);
        i++;
    }
    while (j < other->n)
    {
        res->append(&other->arr[j]);
        j++;
    }
    return res;
}
 
// drive program
int main()
{
    Building arr[] = {{1, 11, 5}, {2, 6, 7}, {3, 13, 9},
                      {12, 7, 16}, {14, 3, 25}, {19, 18, 22},
                      {23, 13, 29}, {24, 4, 28}};
    int n = sizeof(arr)/sizeof(arr[0]);
 
    // Find skyline for given buildings and print the skyline
    SkyLine *ptr = findSkyline(arr, 0, n-1);
    cout << " Skyline for given buildings is \n";
    ptr->print();
    return 0;
}
 Skyline for given buildings is
 (1, 11),  (3, 13),  (9, 0),  (12, 7),  (16, 3),  (19, 18), 
 (22, 3),  (23, 13),  (29, 0),
Time complexity of above recursive implementation is same as Merge Sort.

T(n) = T(n/2) + Θ(n)

Solution of above recurrence is Θ(nLogn)

// solution using heap

The idea is to sort all critical points first. Then keep track of an active set of buildings with a max priority queue. When it comes to the left edge of a building, add its height to the maxPQ. When it comes to the right edge, remove the height. The add/remove operation for pq takes logN time, peek operation is constant time. The overall time complexity should be O(n * log(n)).

class Pair implements Comparable<Pair> {
    int index;
    int height;
    Pair(int i, int h) {
        this.index = i;
        this.height = h;
    }

    public int compareTo(Pair p) {
        // if index is different, smaller index comes first
        if (this.index != p.index) return this.index - p.index;
        // if the right end and left start overlap, left start point comes first
        if (p.height * this.height < 0) return this.height - p.height;
        // overlap on the left edge, the bigger value comes first
        if (this.height < 0 && p.height < 0) return Math.abs(p.height) - Math.abs(this.height);
        // overlap on the right value, the smaller values comes first
        return Math.abs(this.height) - Math.abs(p.height);
    }

}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList();
        if (buildings == null || buildings.length == 0) return result;
        int len = buildings.length;
        Pair[] pairs = new Pair[2 * len];
        for (int i = 0; i < len; i++) {
            pairs[2 * i] = new Pair(buildings[i][0], -buildings[i][2]);
            pairs[2 * i + 1] = new Pair(buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(pairs);
        int height = 0;
        // Priority queue in java allows duplicates
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        for (Pair p: pairs) {
            if (p.height < 0) maxPQ.add(-p.height);
            else maxPQ.remove(p.height);
            int newH = (maxPQ.peek() == null) ? 0 : maxPQ.peek();
            if (newH != height) {
                height = newH;
                int[] re = new int[2];
                re[0] = p.index;
                re[1] = height;
                result.add(re);
            }
        }
        return result;
    }
}

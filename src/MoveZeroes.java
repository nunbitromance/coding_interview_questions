/*Move Zeroes
Modify the array by moving all the zeros to the end (right side). The order of other elements doesn’t matter.
Let’s have an example. For array [1, 2, 0, 3, 0, 1, 2], the program can output [1, 2, 3, 1, 2, 0, 0].

This question move zeroes has been asked by Uber recently (at the time of writing). One reason I’d like to discuss this 
problem is that it seems so simple at first glance, but you’ll be surprised at how many people didn’t get it right with a time limit.
*/

public void moveZeroes(int[] arr) {
  int left = 0;
  int right = arr.length - 1;
  
  while (left < right) {
    while (arr[left] != 0) {
      left++;
    }
    if (left < right && arr[right] != 0) {
      arr[left] = arr[right];
      arr[right] = 0;
      right--;
    }
  }
}

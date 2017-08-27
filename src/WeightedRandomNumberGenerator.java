/*
http://blog.gainlo.co/index.php/2016/11/11/uber-interview-question-weighted-random-numbers/

Write a function that returns values randomly, according to their weight.
Let me give you an example. Suppose we have 3 elements with their weights: A (1), B (1) and C (2). The function should return A with probability 25%, B with 25% and C with 50% based on the weights.

The answer is not obvious, but it’s not too hard to think. Also, writing bug-free code would fail majority candidates. This is really the perfect question for coding interviews.

If you haven’t solved this problem before, I’ll give you 20min for both thinking and coding. Please try to solve it before reading the analysis below.
*/

public int generateRandom(int[] values, int[] weights) {

  int sum = 0;
  // add weights.
  for (int i = 0; i < values.length; i++) {
    sum += weights[i];
  }

  // generate a random number between 0 and sum inclusive.
  int r = new Random().nextInt(sum + 1);
  
  // iterative approach
  for (int i = 0; i < values.length; i++) {
    if (r <= weights[i]) {
      return values[i];
    }
    r = r - weights[i];
  }
  
  /* binary search approach
  int[] dist = new int[values.length];
  int sum = 0;
  for (int i = 0; i < values.length; i++) {
    sum += weights[i];
    dist[i] = sum;
  }
  
  // find the first node that has value greater than r.
  int begin = 0;
  int end = values.length - 1;
  
  while (begin < end) {
    int mid = begin + (end - begin) / 2;
    
    if (r <= dist[mid] && r > dist[mid - 1]) {
      return values[mid];
    } else if (r < dist[mid]) {
      begin = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  
  return -1;*/
}

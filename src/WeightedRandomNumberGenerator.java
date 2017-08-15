http://blog.gainlo.co/index.php/2016/11/11/uber-interview-question-weighted-random-numbers/

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

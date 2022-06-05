import java.util.*;

class Solution {
  static class Pair<K, V> {

    public K key;
    public V val;

    public Pair(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }

  public static void main(String[] args) {
    int[] arr =  {3, 1, 2, 1, 2, 1, 5, 5, 3, 9, 2, 4, 5, 1, 1, 2};
    List<Integer> res = getTopKSellingItems(arr, 3);
    System.out.print("res: " + res);
  }

  public static List<Integer> getTopKSellingItems(int[] input, int k) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i : input) {
      if (hashMap.containsKey(i)) {
        hashMap.put(i, hashMap.get(i)+1);
      } else {
        hashMap.put(i, 1);
      }
    }

    System.out.println("hashMap=" + hashMap);

    PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.val - o2.val;
      }
    });

    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (heap.size() < k) {
        heap.add(new Pair<Integer, Integer>(entry.getKey(), entry.getValue()));
      } else if (heap.peek().val < entry.getValue()) {
        heap.poll();
        heap.add(new Pair<Integer, Integer>(entry.getKey(), entry.getValue()));
      }
    }

    List<Integer> result = new ArrayList<>();
    while (heap.size() > 0) {
      result.add(0, heap.poll().key);
    }
    return result;
  }
}

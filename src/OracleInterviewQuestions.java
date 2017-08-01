1. Longest palindrome in a string
2. Implement a hash table
3. Binary search 2D  
4. printing elements in sorted order of a row sorted matrix: merge k-sorted arrays
5. Design file structure using maps  
6. Implement a doubly linked list delete operation.
7. write a deck of card question with the oop? 
8. reverse a linked list in place.  
9. Write a parser for CSV files

cat, dog, cat, bird => cat
cat, dog, cat, dog, bird => cat, dog
[] => []
null => throw IllegalArgumentException
cat => cat
cat, cat, cat, dog, dog, bear => cat, cat, cat
large number of words => 

public List<String> topFrequentWords(List<String> words) {
    // validate
    
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
        if (!map.contains(words[i])) {
            map.put(words[i], 1);
        } else {
            map.put(words[i], map.get(words[i])+1);
        }
    }
    
    int max = Integer.MIN_VALUE;
    foreach (Map.Entry<String, Integer> kvp : map.getEntries()) {
        if (kvp.value == max) {
            max = kvp.value;
            result.add(kvp.key);
        } else if (kvp.value > max) {
            max = kvp.value;
            result.clear();
            result.add(kvp.key);
        }
    }
    
    return result;
}

10, 2 => 5
9, 2 => 4
1, 2 => 0
1, 0 => IllegalArgumentException
-10, 2 => -5
10, -2 => -5
large number, small number
large number, large number
public int divide(int a, int b) {
    // validate
    if (b == 0) {
        throw IllegalArgumentException("b is zero");
    }

    boolean isNeg = (a < 0 && b > 0) || (a > 0 && b < 0);

/*
    int count = 0;
    long sum = 0;
    while (sum < a) {
        sum += b;
        count++;
    }
  */
  
    int count = 0;
    long sum = 0;  
    while (sum < a) {
        sum += count * b;    //2, 2, 2, 2, 2,... 10 times  2, 4 = 2*2, 8 = 2*4, 16 = 2*8, 32 = 2 * 16
        count *= 2;
    }
    
    // replace with binary search?
    while (count * b < a) {
        count--;
    }
    
    return isNeg == true ? -1 * count : count;
}


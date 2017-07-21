public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] sol = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i+1);
        }
        for (int i = 0 ; i < numbers.length; i++) {
            int minusN = target - numbers[i];
            if (map.containsKey(minusN)) {
                sol[0] = i+1;
                sol[1] = map.get(minusN);
                if (sol[0] == sol[1]) {
                    continue;
                }
                return sol;
            }
        }
        return sol;
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        Arrays.sort(numbers);
        while (i < j) {   
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
              return new int[] { numbers[i], numbers[j] };  
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return sol;
    }
}

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
}

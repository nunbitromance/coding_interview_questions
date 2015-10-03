// P = n! / (n-k)!
/* 
Print all permutations of a string
abc => abc, acb, bac, bca, cba, cab
3! / 0! = 6
*/
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(num, 0, result);
        return result;
    }
    
    private void permute(int[] num, int i, List<List<Integer>> result) {
        if (i == num.length) {
            List<Integer> r = new ArrayList<Integer>();
            for (int k = 0; k < num.length; k++) {
                r.add(num[k]);
            }
            result.add(r);
            return;
        }
        
        for (int j = i; j < num.length; j++) {
            swap(num, i, j);
            permute(num, i + 1, result);
            swap(num, j, i);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// aba => aba, aab, baa
public class PermutationsWithRepetition {

    public void permute(char[] arr, int start) {
        if (start == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i == start || arr[i] != arr[start]) {
                swap(arr, i, start);
                permute(arr, start+1);
                swap(arr, i, start);
            }
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] cArr = new char[] {'a','b','a'};
        //Arrays.sort(cArr);
        new PermutationsWithRepetition().permute(cArr, 0);
    }

}

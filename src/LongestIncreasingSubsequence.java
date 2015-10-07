

http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
// OPT(i) = 1 + max{OPT(j)} for j < i and A[i] >= A[j]
// For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
    /**
     * DP way of solving LIS
     */

public class LongestIncreasingSubsequence {

    public void longestIncreaseingSubsequence(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = 1;
        int[] prev = new int[arr.length];
        prev[0] = -1;
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && opt[j] + 1 > opt[i]) {
                    opt[i] = opt[j] + 1;
                    prev[i] = j;
                }
            }
        }
        
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (opt[i] > opt[maxIndex]) {
                maxIndex = i;
            }
        }
        
        int t = maxIndex;
        while (t >= 0) {
            System.out.println(arr[t]);
            t = prev[t];
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = new int[]{ 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        new LongestIncreasingSubsequence().longestIncreaseingSubsequence(arr);
    }

}

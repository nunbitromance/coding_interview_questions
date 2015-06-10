/*
Jump GameMar 25 '12
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

We can track the maximum length a position can reach. The key to solve this problem is to find: 1) when the position can not reach next step (return false) , and 2) when the maximum can reach the end (return true).

public boolean canJump(int[] A) {
    if(A.length <= 1)
        return true;
 
    int max = A[0];
 
    for(int i=0; i<A.length; i++){
        //if not enough to go to next
        if((max <= i && A[i] == 0) || max < i) 
            return false;
 
        //update max    
        if(i + A[i] > max){
            max = i + A[i];
        }
 
        //max is enough to reach the end
        if(max >= A.length-1) 
            return true;
    }
 
    return false;    
}
/*
Jump Game IIMar 17 '12
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
    public int minJump(int[] jumps) {
        int[] opt = new int[jumps.length];
        
        opt[0] = 0;
        
        for (int i = 1; i < jumps.length; i++) {
            int minJump = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (jumps[j] + j >= i) {
                    minJump = Math.min(minJump, opt[j] + 1);
                }
            }
            opt[i] = minJump;
        }
        
        return opt[jumps.length - 1];
    }

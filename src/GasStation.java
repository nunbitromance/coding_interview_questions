/*There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int j = 0;
        for (int i = 0; i < gas.length; i+=j) {
            int gasLeft = 0;
            for (j = 0; j <= gas.length; j++) {
                int k = (i + j) % gas.length;
                gasLeft += gas[k] - cost[k];
                if (gasLeft <= 0) {
                    break;
                }
            }
            if (j >= gas.length) {
                return i;
            }
        }
        return -1;
    }
}

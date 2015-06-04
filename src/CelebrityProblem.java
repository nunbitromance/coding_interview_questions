16. Consider an X x Y array of 1's and 0s. The X axis   represents "influences" meaning that X influences Y. 
So, for example, if $array[3,7] is 1 that means that 3 influences 7. 
An "influencer" is someone who influences every other person, but is not influenced by any other member. 
Given such an array, write a function to determine whether or not an "influencer" exists in the array. 

public boolean isInfluencerExists(int[][] graph) {
	int[] degreeIn = new int[graph.length];
	int[] degreeOut = new int[graph.length];
	
	for (int i = 0; i < graph.length; i++) {
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[i][j] == 1) {
				degreeOut[i]++;
				degreeIn[j]++;
			}
		}
	}
	
	for (int i = 0; i < graph.length; i++) {
		if (degreeOut[i] == 0 && degreeIn[i] == graph.length - 2) {
			return true;
		}
	}
	return false;
}

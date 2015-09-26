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

/*
                A
             ^  ^  ^
            /   |   \ 
           /    |    \
          B <-> C     \
                 ^     \
                  \     \
                   ------D

B knows A and C
C knows A and B
D knows A and C                   
*/
public class Person {
    public boolean knows(Person n);
}                   

1. pick A as candidate
2. is B pointing to A? yes, rule out B
3. is C pointing to A? yes, rule out C
4. is D pointing to A? yes, rule out D
5. does A know any one of {B, C, D}?

D,B,C,A
1. pick D as candidate
2. is B pointing to D? no, rule out D
3. pick B as candidate
4. is C pointing to B? yes, rule out C
5. is A pointing to B? no, pick A as candidate
6. does {B, C, D} know A && A does not know anyone else?

// Return the lonely celebrity (if one exists)
Person findLonelyCelebrity(List<Person> people) {
    // validation
    if (people == null) {
        throw new IllegalArgException("people is null");
    } else if (people.size() == 0) {
        return null;
    }
    
    int i = 0; int j = 1;
    while (j < people.size()) {
    	if (knows(people.get(i), people.get(j)) {
    		candidate = people.get(j);
    	}
    	j++;
    }
    
    for (int k = 0; k < people.size(); k++) {
    	if (i != k && knows(people.get(i), people.get(k))) {
    		return null;
    	}
    }
    
    return people.get(i);
}

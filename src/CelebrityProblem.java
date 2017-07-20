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

// Return the lonely celebrity (if one exists)
Person findLonelyCelebrity(List<Person> people) {
    // validation
    if (people == null) {
        throw new IllegalArgException("people is null");
    } else if (people.size() == 0) {
        return null;
    }
    
    int i = 0; int j = people.size() - 1;
    // eliminate non-celebrity
    while (i < j) {
    	if (knows(people.get(i), people.get(j)) {
    		i++;
    	} else {
    	  j--;
      }
    }
    
    for (int k = 0; k < people.size(); k++) {
    	if (i != k && knows(people.get(i), people.get(k))) {
    		return null;
    	}
    }
    
    return people.get(i);
}

//A circus is designing a tower routine consisting of people standing atop one another's shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower. e.g.
//
//INPUT: (ht, wt): (65, 100) (90, 150) (50, 120) (56, 90) (75, 190) (60, 95) (68, 110) (80, 92).
//OUTPUT: the longest tower is length 5 and includes from top to bottom: (56, 90), (60, 95), (65, 100), (68, 110), (90, 150).
public class HtWt : IComparable
{
	public int Height {get;set;}
	public int Weight {get;set;}
	
	public int CompareTo(HtWt s)
	{
		if (s == null)
		{
			return 1;
		}
		if (Height != s.Height)
		{
			return Height.CompareTo(s.Height);
		}
		else if (Weight != s.Weight)
		{
			return Weight.CompareTo(s.Weight);
		}
		return 0;
	}
}

public static List<HtWt> GetLongestIncreasingSubsequence(HtWt[] people)
{
	if (people == null)
	{
		throw new ArgumentNullException("people");
	}
	Dictionar<int, List<HtWt>> result = new Dictionary<int, List<HtWt>>();
	if (people.length == 0)
	{
		return result;
	}
	
	// sort by height then weight
	// before: (65, 100) (90, 150) (50, 120) (56, 90) (75, 190) (60, 95) (68, 110) (80, 92)
	// after:  (50, 120) (56, 90) (60, 95) (65, 100) (68, 110) (75, 190) (80, 92) (90, 150)
	people.Sort();
	int[] maxLength = new int[people.length];
	maxLength[0] = 1;
	result.Add(0, new List<HtWt>(){people[0]});
	
	for (int i = 1; i < maxLength.length; i++)
	{
		List<HtWt> cur = null;
		int maxLength = 0;
		for (int j = i - 1; j >= 0; j--)
		{
			if (people[j] < people[i] && maxLength[j] > maxLength)
			{
				maxLength = maxLength[j];
				cur = result.Get(j);
			}
		}
		// add current i into the cur list to get the max length sequence so far.
		List<HtWt> maxPeople = new List<HtWt>();
		maxPeople.AddRange(cur);
		maxPeople.Add(people[i]);
		result.Add(i, maxPeople);
		
		maxLength[i] = maxLength + 1;
	}
	
	// return the last list.
	return result.Get(people.length - 1);
}
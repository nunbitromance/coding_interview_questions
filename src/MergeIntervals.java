/*
Merge IntervalsMar 27 '12
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

» Solve this problem
*/
public static List<Interval> MergeIntervals(List<Interval> intervals)
{
	intervals.Sort(new IntervalComparator());
	
	Interval cur = intervals[0];
	List<Interval> result = new List<Interval>();
	for (int i = 1; i < intervals.Length; i++)
	{
		Interval next = intervals[i];
		
		if (next.Start < cur.End)
		{
			// overlapping: merge
			result.Add(new Interval(cur.Start, next.End));
			i++;
		}
		else
		{
			result.Add(cur);
		}
		
		cur = next;
	}
}

public class IntervalComparator<Interval> : IComparator<Interval>
{
	public int Compare(Interval a, Interval b)
	{
		return a.Start - b.Start;
	}
}
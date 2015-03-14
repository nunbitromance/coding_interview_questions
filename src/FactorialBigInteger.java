/*
 * How to calculate factorial of a big integer.
 */
public class BigIntegerComparator<BigInteger> : IComparator
{
	public int compare(BigInteger a, BigInteger b)
	{
		return a.compareTo(b);
	}
}

public static BigInteger factorial(int n)
{
	PriorityQueue<BigInteger> pq = new PriorityQueue<BigInteger>(new BigIntegerComparator());
	
	pq.insert(new BigInteger(1));
	pq.insert(new BigInteger(2));
	
	while (pq.size() > 1)
	{
		pq.insert(pq.poll() * pq.poll());
	}
	
	return pq.poll();
}
/* There is an old dry well. Its sides are made of concrete rings. Each such ring is one meter high, but the rings can have different (internal) diameters. Nevertheless, all the rings are centered on one another. The well is N meters deep; that is, there are N concrete rings inside it. You are about to drop M concrete disks into the well. Each disk is one meter thick, and different disks can have different diameters. Once each disk is dropped, it falls down until:

it hits the bottom of the well;
it hits a ring whose internal diameter is smaller then the disk's diameter; or
it hits a previously dropped disk. (Note that if the internal diameter of a ring and the diameter of a disk are equal, then the disk can fall through the ring.)
The disks you are about to drop are ready and you know their diameters, as well as the diameters of all the rings in the well. The question arises: how many of the disks will fit into the well?

Write a function: int falling_disks(int A[], int N, int B[], int M); that, given two zero-indexed arrays of integers ? A, containing the internal diameters of the N rings (in top-down order), and B, containing the diameters of the M disks (in the order they are to be dropped) ? returns the number of disks that will fit into the well. For example, given the following two arrays:

      A[0] = 5    B[0] = 2
      A[1] = 6    B[1] = 3
      A[2] = 4    B[2] = 5
      A[3] = 3    B[3] = 2
      A[4] = 6    B[4] = 4
      A[5] = 2
      A[6] = 3

*/
public static int fallingDisks(int[] A, int[] B)
{
	if (A == null)
	{
		throw new ArgumentNullException("a");
	}
	if (B == null)
	{
		throw new ArgumentNullException("b");
	}
	
	// stop the gaps.
	int min = Int.Max;
	for (int i = 0; i < A.length; i++)
	{
		if (A[i] < min)
		{
			min = A[i];
		}
		else
		{
			A[i] = min;
		}
	}
	
	// fill the rings.
	int i = A.length - 1;
	int j = 0;
	int count = 0;
	while (j < B.length && i > 0)
	{
		if (A[i] > B[j])
		{
			i--; j++;
			count++;
		}
		else
		{
			i--;
		}
	}
	return count;
}
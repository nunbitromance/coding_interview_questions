using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    class Q_SmallestOneMillionNumbers
    {
        public static int QuickSelect(int[] array, int rank, int lo, int hi)
        {
            int mid = (lo + hi) / 2;

            int bound = Partition(array, mid);

            if (bound == rank)
            {
                return array[bound];
            }
            else
            {
                if (bound < rank)
                {
                    return QuickSelect(array, rank - mid, bound + 1, hi);
                }
                else
                {
                    return QuickSelect(array, rank, lo, bound);
                }
            }
        }

        public static int Partition(int[] array, int pivotIndex)
        {
            int left = 0;
            int right = 0;

            while (left < right)
            {
                while (array[left] < array[pivotIndex])
                {
                    left++;
                }
                while (array[right] < array[pivotIndex])
                {
                    right--;
                }

                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }

            return left - 1;
        }

    }
}

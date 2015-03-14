// merge sort algorithm
public static void mergeSort(int[] array, int begin, int end)
{
    if (begin >= end)
    {
        return;
    }

    int mid = begin + (end - begin)/2;

    mergeSort(array, begin, mid);
    mergeSort(array, mid + 1, end);

    merge(array, begin, mid, end);
}

private static void merge(int[] array, int begin, int mid, int end)
{
    int[] temp = new int[end - begin + 1];
    int i = begin;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= end)
    {
        if (array[i] > array[j])
        {
            temp[k++] = array[j++];
        }
        else
        {
            temp[k++] = array[i++];
        }
    }
    while (i <= mid)
    {
        temp[k++] = array[i++];
    }
    while (j <= end)
    {
        temp[k++] = array[j++];
    }

    temp.CopyTo(array, begin);
}
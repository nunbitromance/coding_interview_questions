// quick sort algorithm
public static void quickSort(int[] array, int begin, int end)
{
    if (begin >= end)
    {
        return;
    }

    int p = partition(array, begin, end);

    quickSort(array, begin, p - 1);
    quickSort(array, p + 1, end);
}


private static int partition(int[] array, int begin, int end)
{
    int pivot = array[end];

    // 4 ,2 ,3, 5, 1
    // 1, 2, 3, 5, 4
    while (begin < end)
    {
        while (begin < end && array[begin] < pivot)
        {
            begin++;
        }
        while (begin < end && array[end] > pivot)
        {
            end--;
        }
        if (begin < end)
        {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }
    }
    return begin;
}
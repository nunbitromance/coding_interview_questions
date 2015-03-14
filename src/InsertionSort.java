/// <summary>
/// Insertion sort algorithm
/// 4, 2, 3, 5, 1 -> 1, 2, 3, 4, 5
/// </summary>
/// <param name="array"></param>
public static void insertionSort(int[] array)
{
    for (int i = 1; i < array.Length; i++)
    {
        int j = i;
        while (j > 0 && array[j] < array[j-1])
        {
            int temp = array[j - 1];
            array[j - 1] = array[j];
            array[j] = temp;
            j--;
        }
    }
}
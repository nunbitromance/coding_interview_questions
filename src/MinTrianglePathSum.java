//Given a triangle, find the minimum path sum from top to bottom 

public int minPath(List<List<Integer>> triangle) 
{
    int[] total = new int[triangle.size()];

    int l = triangle.size() - 1;
 
    for (int i = 0; i < triangle[l].size(); i++) 
    {
        total[i] = triangle[l][i];
    }
 
    // iterate from second last row
    for (int i = triangle.size() - 2; i >= 0; i--) 
    {
        for (int j = 0; j < triangle[i + 1].size() - 1; j++) 
        {
            total[j] = triangle[i][j] + Math.min(total[j], total[j + 1]);
        }
    }
 
    return total[0];
}


// max sum

//  Function for finding maximum sum
int maxPathSum(int tri[][N], int m, int n)
{
     // loop for bottom-up calculation
     for (int i=m-1; i>=0; i--)
     {
        for (int j=0; j<=i; j++)
        {
            // for each element, check both
            // elements just below the number
            // and below right to the number
            // add the maximum of them to it
            if (tri[i+1][j] > tri[i+1][j+1])
                tri[i][j] += tri[i+1][j];
            else
                tri[i][j] += tri[i+1][j+1];
        }
     }
 
     // return the top element
     // which stores the maximum sum
     return tri[0][0];
}

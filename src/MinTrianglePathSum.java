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

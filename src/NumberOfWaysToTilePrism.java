/*
Given 3 x N rectangle, determine how many ways can we tile
*/

int getCount(int n)
{
    vector<int> f(n + 1);
    f[0] = 1;
    f[1] = 1;
    f[2] = 1;
    for(int i = 3; i <= n; i++)
    {
        f[i] = f[i-1] + f[i-3];
    }
    return f[n];
}

use this recurrence : F(N) = F(N - 1) + F(N - 3)
with base case : F(0) = F(1) = F(2) = 1

Here, F(N) represents no of ways of tiling a 3XN grid with 3X1 or 1X3 tiles. 

if you place a 3X1 tile, then you just need to solve for F(N - 1).
if you place a 1x3 tile, then you cant place a 3x1 tile under it. Basically, you will have to place a set of three 1x3 tiles together, hence you solve for F(N - 3). 
Take the sum, and you get the recurrence i mentioned above. 

Hope this helps :)

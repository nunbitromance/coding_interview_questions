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

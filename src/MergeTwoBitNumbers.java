/* n = 10000000000, m = 10011, i = 2, j = 6
result=10001001100
*/
public int updateBits(int n, int m, int i, int j) {
  int allOnes = ~0;
  int left = allOnes << (i+1);
  int right = ((1<<i) - 1); // nice trick.
  int mask = left | right; // all 1's except for m's new spot
  int n_cleared = n & mask; 
  int m_cleared = m << i;
  
  return n_cleared | m_cleared;
}

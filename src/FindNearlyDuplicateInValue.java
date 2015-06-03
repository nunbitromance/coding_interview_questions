// duplicate if within value range of [v - k, v + k]
public int findNumWithinRange(int[] n, int k) {
	Set<Integer> s = new HashSet<Integer>();
	for (int i = 0; i < n.length; i++) {
		for (int j = n[i] - k; j <= n[i] + k && j != n[i]; j++) {
			if (s.contains(j)) {
				return j;
			}
		} 
		s.put(n[i]);
	}
}

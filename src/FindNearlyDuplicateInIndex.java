// 2, 4, 3, 2, 1, 6, 7, 9, 0
// if out of range index > k, duplicate allowed.
public int findDuplicate(int[] n, int k) {
	Set<Integer> s = new HashSet<Integer>();
	for (int i = 0; i < n.length; i++) {
		if (s.contains(n[i])) {
			return n[i];
		} else {
			s.put(n[i]);
		}
		if (i - k >= 0) {
			s.remove(n[i - k]);
		}
	}
	return -1; // or some code.
}

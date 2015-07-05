public void rotate(int[][] matrix) {
	int n = matrix.length;
	for (int i = 0; i < n / 2; i++) {
		for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[n-1-j][i];
			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
			matrix[j][n-1-i] = temp;
		}
	}
}

public static void rotate(int[][] matrix, int n) {
2 for (int layer = 0; layer < n / 2; ++layer) {
3 int first = layer;
4 int last = n - 1 - layer;
5 for(int i = first; i < last; ++i) {
6 int offset = i - first;
7 int top = matrix[first][i]; // save top
8 // left -> top
9 matrix[first][i] = matrix[last-offset][first];
10
11 // bottom -> left
12 matrix[last-offset][first] = matrix[last][last - offset];
13
14 // right -> bottom
15 matrix[last][last - offset] = matrix[i][last];
16
17 // top -> right
18 matrix[i][last] = top; // right <- saved top
19 }
20 }
21 }

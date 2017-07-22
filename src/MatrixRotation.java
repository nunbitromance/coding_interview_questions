 public void rotate(int[][] matrix) {  
   for (int level = 0, len = matrix.length; level < len; ++level, --len) {  
     int end = len - 1;  
     for (int pos = level; pos < end; ++pos) {  
       int tail = matrix.length - pos - 1;  
   
       int tmp = matrix[level][pos];  
       // left -> top  
       matrix[level][pos] = matrix[tail][level];  
       // bottom -> left  
       matrix[tail][level] = matrix[end][tail];  
       // right -> bottom  
       matrix[end][tail] = matrix[pos][end];  
       // top -> right  
       matrix[pos][end] = tmp;  
     }  
   }  
 }  


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
	for (int layer = 0; layer < n / 2; ++layer) {
		int first = layer;
		int last = n - 1 - layer;
		for (int i = first; i < last; ++i) {
			int offset = i - first;
			int top = matrix[first][i]; // save top
			// left -> top
			matrix[first][i] = matrix[last-offset][first];
			// bottom -> left
			matrix[last-offset][first] = matrix[last][last - offset];
			// right -> bottom
			matrix[last][last - offset] = matrix[i][last];
			// top -> right
			matrix[i][last] = top; // right <- saved top
		}
	}
}

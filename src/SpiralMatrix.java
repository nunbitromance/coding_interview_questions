/*
Given a matrix (2D array) of m x n elements (m rows, n columns), write a function that prints the elements in the array in a spiral manner.
*/

public class SpiralMatrix {

    public void printSpiral(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        } else if (rowStart == rowEnd && colStart == colEnd) {
            System.out.println(matrix[rowStart][colStart]);
            return;
        }
        
        //print up
        for (int i = colStart; i < colEnd; i++) {
            System.out.println(matrix[rowStart][i]);
        }
        //print right side
        for (int j = rowStart; j < rowEnd; j++) {
            System.out.println(matrix[j][colEnd]);
        }
        // print bottom
        for (int k = colEnd; k > colStart; k--) {
            System.out.println(matrix[rowEnd][k]);
        }
        // print left side
        for (int l = rowEnd; l > rowStart; l--) {
            System.out.println(matrix[l][colStart]);
        }
        printSpiral(matrix, rowStart+1, rowEnd-1, colStart+1, colEnd-1);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,2,3,4,5};
        matrix[1] = new int[]{6,7,8,9,10};
        matrix[2] = new int[]{11,12,13,14,15};
        matrix[3] = new int[]{16,17,18,19,20};
        matrix[4] = new int[]{21,22,23,24,25};
        
        new SpiralMatrix().printSpiral(matrix, 0, 4, 0, 4);
    }

}

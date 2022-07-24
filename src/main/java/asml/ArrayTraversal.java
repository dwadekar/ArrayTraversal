package asml;

/**
 * Class for Traversing 2D array elements
 */
public class ArrayTraversal {
    private static final String SEPARATOR = " ";

    /**
     * Method to print spiral traversal for given 2D Array
     *
     * @param array Input 2D array for traversal
     * @param row   Number of rows of 2D array
     * @param column Number of columns of 2D array
     * @return print result of each element traversal
     */
    public static String printClockwiseMatrix(int[][] array, int row, int column) {
        //Check for null or empty array
        if(array == null || array.length == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int rowStart = 0, rowEnd = row - 1;
        int columnStart = 0, columnEnd = column - 1;

        while(rowStart <= rowEnd && columnStart <= columnEnd) {
            //Towards Right direction from top left corner
            for(int i = columnStart; i <= columnEnd; i++) {
                result.append(array[rowStart][i]).append(SEPARATOR);
            }
            rowStart = rowStart + 1;
            //Towards Down direction from top right corners
            for(int i = rowStart; i <= rowEnd; i++) {
                result.append(array[i][columnEnd]).append(SEPARATOR);
            }
            columnEnd = columnEnd - 1;
            //Boundary condition when single row and multiple columns exists
            if(rowStart <= rowEnd) {
                //Towards Left direction from bottom right corner
                for(int i = columnEnd; i >= columnStart; i--) {
                    result.append(array[rowEnd][i]).append(SEPARATOR);
                }
                rowEnd = rowEnd - 1;
            }
            //Boundary condition when single column and multiple rows exists
            if(columnStart <= columnEnd) {
                //Towards Up direction from bottom left corner
                for(int i = rowEnd; i >= rowStart; i--) {
                    result.append(array[i][columnStart]).append(SEPARATOR);
                }
                columnStart = columnStart + 1;
            }
        }

        return result.toString().trim();
    }

    /**
     * Main method to execute Array Traversal
     *
     * @param args Input Arguments of Java class
     */
    public static void main(String[] args) {
        int[][] matrixArray = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int rows = matrixArray == null ? 0 : matrixArray.length;
        int columns = matrixArray == null ? 0 : matrixArray[0].length;
        String result = printClockwiseMatrix(matrixArray, rows, columns);
        System.out.println(result);
    }
}

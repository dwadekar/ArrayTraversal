package asml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ArrayTraversalTest {
    private static int[][] matrixArray;

    @AfterEach
    public void tearDown() {
        matrixArray = null;
    }

    @Test
    @DisplayName("Boundary Traversal with same length of row and column")
    void printArrayWithSameRowAndColumnLength() {
        matrixArray = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, matrixArray[0].length);
        assertEquals("1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10", result);
    }

    @Test
    @DisplayName("Boundary Traversal with different length of row and column")
    void printArrayWithDifferentRowAndColumnLength() {
        matrixArray = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, matrixArray[0].length);
        assertEquals("1 2 3 4 5 10 15 14 13 12 11 6 7 8 9", result);
    }

    @Test
    @DisplayName("Boundary Traversal with single row and multiple columns")
    void printArrayWithSingleRowAndMultipleColumn() {
        matrixArray = new int[][]{
                {1, 2, 3, 4, 5, 6}
        };
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, matrixArray[0].length);
        assertEquals("1 2 3 4 5 6", result);
    }

    @Test
    @DisplayName("Boundary Traversal with multiple rows and single column")
    void printArrayWithMultipleRowsAndSingleColumn() {
        matrixArray = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, matrixArray[0].length);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    @DisplayName("Boundary Traversal with single row and single column")
    void printArrayWithSingleRowAndSingleColumn() {
        matrixArray = new int[][]{
                {1}
        };
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, matrixArray[0].length);
        assertEquals("1", result);
    }

    @Test
    @DisplayName("Boundary Traversal with no row matrix")
    void printArrayWithNoRowMatrix() {
        matrixArray = new int[][]{};
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, matrixArray.length, 0);
        assertNull(result);
    }

    @Test
    @DisplayName("Boundary Traversal with null matrix")
    void printArrayWithNullMatrix() {
        String result = ArrayTraversal.printClockwiseMatrix(matrixArray, 0, 0);
        assertNull(result);
    }

    @Test
    @DisplayName("Default Test Case")
    void printClockwiseMatrix() {
    }
}
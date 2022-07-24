# ArrayTraversal
Traverse the array in the given pattern and print the numbers along the path.

## Problem Statement:
Given a 2D array 
    {{1,2,3,4},
    {5,6,7,8},
    {9,10,11,12},
    {13,14,15,16}}
Traverse the array in the pattern below and print the numbers along the path.
Print: 1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11,10

## Solution:

The main idea is to iterate over 2D array along boundaries in clockwise manner. With each iteration along boundaries will print each number.
Boundaries of 2D array is defined using four variables:
1. rowStart: represent start of a row which would help to move towards right
2. rowEnd: represent end of a row which would help to move towards left
3. columnStart: represent start of a column which would help towards up and down movement
4. columnEnd: represent end of a column which would help towards up and down movement

We can use nested loops to iterate over 2D array:
1. Outer loop using while condition: Iteration over each boundary within 2D array
2. Four for loops: Print each element while iterating
With each iteration reduce boundaries with above variables by 1.

### Boundary Conditions:
1. When we reach at bottom of 2D array, as we have increased rowStart by 1. So what if array contains only single row and multiple columns, so we need to start iterating at bottom if rowStart <= rowEnd condition which prevents exceeding of boundaries.
``` java
    if(rowStart <= rowEnd) {
        for(int i = columnEnd; i >= columnStart; i--) {
            result.append(array[rowEnd][i]).append(SEPARATOR);
        }
        rowEnd = rowEnd - 1;
    }
``` 
2. Similarly, when we reach at left columns of 2D array, as we have decreased columnEnd by 1. So what if array contains only single column and multiple rows, so we need to start iterating upwards from bottom if columnStart <= columnEnd condition which prevents exceeding of boundaries.
``` java
    if(columnStart <= columnEnd) {
        for(int i = rowEnd; i >= rowStart; i--) {
            result.append(array[i][columnStart]).append(SEPARATOR);
        }
        columnStart = columnStart + 1;
    }
```
3. Handling null 2D array case if array is null in input.
4. Handling zero length 2D array case

> Note: For all the above-mentioned use cases respective JUnit cases are present under src/main/test package.

### Time and Space Complexities:
Time Complexity: O(m*n) where m - rows of 2D array, n - columns of 2D array
Space Complexity: O(1)

### How to run program:
1. Import project as Maven project into IDE of your choice. (I have implemented code logic using Intellij. So writing this from Intellij perspective.)
2. To run test case, right click on project and select *All Tests*
3. To execute program from main class, using _Run Configuration_ execute main class within Intellij.

### Improvements:
If we consider Anti-clockwise traversal within given 2D array, then we can try to generalize code from perspective of directions that we want to travel like below
1. TOWARDS_LEFT from either top right or bottom right
2. TOWARDS_RIGHT from either top left or bottom left
3. TOWARDS_UP from either right vertical or left vertical movement
4. TOWARDS_DOWN from either right vertical or left vertical movement

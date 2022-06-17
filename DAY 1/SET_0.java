import java.util.* ;
import java.io.*; 
public class SET_0 {


//  1st approach  -------- > bruteforce create a 2d boolean matric and use it


// 2nd algorithm
//     Store dimensions of matrix in n and m.
//     Declare boolean arrays “rowZero” and “colZero” of size n and m respectively.
//     Iterate over i from 0 to n
//         Iterate over j from 0 to m
//             If matrix[i][j] == 0
//                 Set colZero[j] = true
//                 Set rowZero[i] = true
//     Iterate over i from 0 to n
//         Iterate over j from 0 to m
//             If rowZero[i] is true or colZero[j] is true
//                 Set matrix[i][j] = 0

    public static void setZeros(int matrix[][]) {
        // Write your code here..
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);
        
        for( int i = 0 ; i < n ; i++) {
            for( int j = 0; j < m ; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
         for( int i = 0 ; i < n ; i++) {
            for( int j = 0; j < m ; j++) {
                if(row[i] == 0 || col[j] == 0) {
                  matrix[i][j] = 0;
                }
            }
        }
        
    }



// 3rd Most Optimised

// setZeros(matrix)

//     Store dimensions of the matrix in n and m.
//     Declare boolean variables “firstRowZero” and “firstColZero” and initialize them to false.
//     Traverse over the first row and if any of it is zero then set firstRowZero to true.
//     Traverse over the first column and if any of it is zero then set firstColZero to true.
//     Iterate over i from 1 to n
//         Iterate over j from 1 to m
//             If matrix[i][j] == 0
//                 Set matrix[i][0] = 0
//                 Set matrix[0][j] = 0
//     Iterate over i from 1 to n
//         Iterate over j from 1 to m
//             If matrix[i][0] == 0 or matrix[0][j] == 0
//                 Set matrix[i][j] = 0
//     If “firstColZero” is true
//         Iterate over i from 0 to n
//             Set matrix[i][0] = 0
//     If “firstColZero” is true
//         Iterate over j from 0 to m
//             Set matrix[0][j] = 0

   
public static void set0s(int matrix[][]) {

    // Storing dimensions of matrix in n and m.
    int n = matrix.length;
    int m = matrix[0].length;

    // Declaring two boolean variables firstColZero and firstRowZero.
    Boolean firstColZero = false, firstRowZero = false;

    // Setting firstColZero to true if any element in first column is zero.
    for (int i = 0; i < n; i++) {
        if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
        }
    }

    // Setting firstRowZero to true if any element in first row is zero.
    for (int j = 0; j < m; j++) {
        if (matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
    }

    // Setting values for each row and column to be zero or not.
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = matrix[0][j] = 0;
            }
        }
    }

    // If any element of first row is zero then that complete column should be zero
    // and vice-versa.
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Setting first row to zero if firstRowZero is true.
    if (firstColZero) {
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
        }
    }

    // Setting first column to zero if firstColZero is true.
    if (firstRowZero) {
        for (int j = 0; j < m; j++) {
            matrix[0][j] = 0;
        }
    }
}

}
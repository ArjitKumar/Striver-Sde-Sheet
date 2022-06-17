import java.util.* ;
import java.io.*; 
public class SET_0 {
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

}
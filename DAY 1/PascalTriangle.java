import java.util.* ;
import java.io.*; 
import java.util.ArrayList;


// remember this formula -----> val = val * (i-j) / (j+1);
// during the starting of i loop initialze val with 1(long) for avoiding overflow

public class PascalTriangle {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        
             for( int i = 0; i < n ; i++) {
            ArrayList<Long> list = new ArrayList<>();
             long val = 1;
            for( int j = 0 ; j <= i ; j++) {
                 
                  list.add(val);
                  val = val * (i-j) / (j+1);
            }
            res.add(list);
        }
        
        return res;
        
	}
}

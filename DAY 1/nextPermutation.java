import java.util.ArrayList;
import java.util.Collections;

public class nextPermutation 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) 
	{
		   if(A.size() <= 1) return new ArrayList<>();
        
        int i = A.size() - 2; // possible point of break kyunki last element nhi ho skta
        
        while( i >= 0 && A.get(i) >= A.get(i+1) )i--;
        
        // we got the point of break swap now we find the element to be swap
        if( i >= 0) {
            int j = A.size() - 1;
            while(A.get(j) <= A.get(i)) j--; //finding the element just greater than i
            swap(A, i , j);
        }
        //
        // reversing the element from i+1 till end to make the permutaion
        reverse( A, i+1, A.size() - 1);
        
        return A;
        
	}
        public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
    public static void reverse(ArrayList<Integer> A, int i , int j) {
        while(i < j) 
        {
            swap(A,i,j);
            i++;
            j--;
        }
        
    }
}


// leetcode 
class Solution {
    public void nextPermutation(int[] A) {
        
        if( A == null || A.length <= 1) return;
        
        int i = A.length - 2; // possible point of break
        
        while( i >= 0 && A[i] >= A[i+1]) i--;
        
        // we got the point of break swap now we find the element to be swap
        if( i >= 0) {
            int j = A.length - 1;
            while(A[j] <= A[i]) j--;
            swap(A, i , j);
        }
        //
        // reversing the element from i+1 till end to make the permutaion
        reverse( A, i+1, A.length - 1);
        
        
        
        
    }
    public void swap( int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public void reverse( int[] A, int i , int j) {
        while(i < j) 
        {
            swap(A,i,j);
            i++;
            j--;
        }
        
    }
}
import java.util.ArrayList;
import java.util.Collections;


// bruteforce ---> using recrursion find all the possible permutation , store them in list then sort them lexographically 
// after that find the position of the permutation given and print the i+1 element and if the permu is last then print the first 





// Most optimal approach  ----------------- > 

// 1 . Start iterating from the end of the given permutation and search a pair of indexes (i, i+1) such that P[i] < P[i+1].
// 2 .If such a pair doesn’t exist, then the permutation is sorted in descending order. And as discussed above, the next permutation will be the lexicographically smallest permutation i.e. the reverse of the given permutation.
// 3 . Suppose we reached an index ‘i’ such that P[i] < P[i+1]. In this case, we can just swap to (i, i+1)th elements but the resulting permutation may not be the just next greater permutation. Therefore, we will start searching for the smallest element which will be on the right side of the ith element and is greater than the ith element. Let's say the index of that element is ‘j’.
// 4 . Now, swap P[i] and P[j]. After the swap operation, we will get a lexicographically greater permutation but that again may not be the immediate next one. Since the element at the ith index in the next permutation is greater than the ith element in the given permutation, we can sort all the elements after ith index in ascending order to ensure that the next permutation is just greater one.
// 5 . Now, notice that the ith index is the first index from the end for which P[i] < P[i+1], i.e. elements in the right side of the ith element must be sorted in descending order. And after doing the swap operation on ith and jth index this order won’t change. Why? Because jth element is the smallest element which is greater than the ith element; i.e. P[j-1] < P[i] < P[j]. Therefore, the resulting sequence (from (i+1)th element to end) is still sorted which means that in order to sort it in ascending order, we can just reverse it.

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
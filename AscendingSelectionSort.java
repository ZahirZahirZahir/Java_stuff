/*
 * algorithm for selection sort in ascending order
 */

package algorithm;

public class AscendingSelectionSort {
	public static void selectionSorting(int[] a) {
		int i, smallestIndexNum;
		for(i=0;i<a.length-1;i++) {
			smallestIndexNum = traceTheSmallestIndexNum(i, a);
			interchange(i, smallestIndexNum, a);
		}
	}
	
	//return the index number of the smallest element in current array
	private static int traceTheSmallestIndexNum(int startIndexNum, int[] a) {
		int minIndex = a[startIndexNum];
		int minIndexNum = startIndexNum;	
		int i; 
		for(i=startIndexNum+1;i<a.length;i++) {
			if(a[i]<minIndex) {
				minIndex = a[i];
				minIndexNum = i;
			}
		}		
		return minIndexNum;
	}	
	
	//interchange values of a[i] and a[j]
	private static void interchange(int i, int j, int[] a) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

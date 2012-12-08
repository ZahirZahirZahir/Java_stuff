/*
 * algorithm for insertion sort in descending order
 */

package infoCoding;

public class InsertionSort {
	public static void insertionSorting(double[] a) {
		//temporary array for saving data
		double[] temp = new double[a.length];
		int i, biggestIndexNum;
		for(i=0;i<a.length-1;i++) {
			biggestIndexNum = traceTheBiggestIndexNum(i, a);
			//insert value(already in order) to temporary array
			temp[i] = a[biggestIndexNum];		
			//"delete" the current a[smallestIndexNum]
			if(i<biggestIndexNum) {
				int j;
				for(j=biggestIndexNum;j>0;j--) {
					a[j] = a[j-1];
				}
			}
		}		
		//copy values from temporary array to target array
		for(i=0;i<a.length-1;i++) {
			a[i] = temp[i];
		}
	}	
	
	//return the index number of the smallest element in current array
	private static int traceTheBiggestIndexNum(int startNum, double[] a) {
		double maxIndex = a[startNum];
		int maxIndexNum = startNum;		
		int i;
		for(i=startNum+1;i<a.length;i++) {
			if(a[i]>maxIndex) {
				maxIndex = a[i];
				maxIndexNum = i;
			}
		}		
		return maxIndexNum;
	}
}


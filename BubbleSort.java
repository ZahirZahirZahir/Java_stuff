/*
 * algorithm for bubble sort in ascending order
 */

package infoCoding;

public class BubbleSort {
	public static void bubbleSorting(double[] a) {
		int i;
		boolean loop = true;
		while(loop) {
			for(i=0;i<a.length-1;i++) {
				if(a[i+1]>a[i]) {
					interchange(i, i+1, a);
				}
			}		
			//test whether the new array is in order
			for(i=0;i<a.length-1;i++) {
				//sorting process performed, end loop
				if(a[i]>=a[i+1]) {
					loop = false;
				}			
				//need more sorting, end checking
				else {
					loop = true;
					i = a.length-1;
				}
			}
		}
	}
	
	//interchange values of a[i] and a[j]
	private static void interchange(int i, int j, double[] a) {
		double temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}



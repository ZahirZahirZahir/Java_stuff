/*
 * A trial program for Huffman coding under the condition that D = 2
 * 
 */

package infoCoding;
import java.util.*;

public class HuffmanCoding {
	private static double[] inputArray;
	private static double[][] codingMatrix;
	private static int[][] outputArrayOfHuffmanCode;
	private static double x;
	public static void runHuffmanCoding() {
		showProgramInstruction();
		inputData();
		processData();
		showDataMatrix();
		showHuffmanCode();		
	}
	
	//display general instructions
	private static void showProgramInstruction() {
		System.out.print("This is a preliminary program ");
		System.out.println("aimming at executing Huffman coding theory");
		System.out.println("under condition that D = 2.");
	}
	
	//receive data from user's keyboard input
	private static void inputData() {
		int i, arrayLength;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please keyboard the dimension(length) of the target array, my lord:");
		/*
		 * non-digit invalid input?
		 */
		arrayLength = keyboard.nextInt();
		if(arrayLength>0) {
			inputArray = new double[arrayLength];
			System.out.println("Got it.");
			System.out.println("Please keyboard the target array, my lord:");
			System.out.println("(input each element by keyboard \"Enter\" key)");
			/*
			 * non-digit invalid input?
			 */
			for(i=0;i<=inputArray.length-1;i++) {
				inputArray[i] = keyboard.nextDouble();
			}
			System.out.println("Got them.");
		}
		else {
			System.out.println("Invalid input! Length should be positive.");
			//recursive procedure
			inputData();
		}		
	}
	
	/*
	 * precondition: get input data
	 * postcondition: execute Huffman-coding rule under condition that D = 2
	 * 				  yield coding array matrix, as well as Huffman code
	 */
	private static void processData() {
		System.out.println("Data processing");
		putDataArrayInOrder();
		spanDataMatix();
		traceHuffmanCodingResult();
	}
	
	/*
	 * precondition: get input data array
	 * postcondition: get data array in ascending order
	 */
	private static void putDataArrayInOrder() {
		BubbleSort.bubbleSorting(inputArray);
	}
	
	/*
	 * precondition: get data array in ascending order
	 * postcondition: create data matrix
	 */
	private static void spanDataMatix() {
		//initialize data matrix
		int i, k=inputArray.length;
		codingMatrix = new double[inputArray.length][];
		for(i=0;i<=inputArray.length-1;i++) {
			codingMatrix[i] = new double[k];
			k--;
		}
		/*
		 * assign value for the whole irregular matrix
		 * note that for merging "last two" elements
		 * i<inputArray.length-1 without "="
		 */
		for(i=0;i<inputArray.length-1;i++) {
			assignValueForAColumn(i);
			mergeLastTwoElements(i);
			putDataArrayInOrder();
		}
		//one more execution needed!!!
		assignValueForAColumn(i);
	}
	
	/*
	 * assign each value to a column of data matrix
	 */
	private static void assignValueForAColumn(int i) {
		int j;
		for(j=0;j<=inputArray.length-1-i;j++) {
				codingMatrix[j][i] = inputArray[j];
		}
	}
	
	/*
	 * precondition: get the "last two" elements of input array
	 * postcondition: add them together
	 */
	private static void mergeLastTwoElements(int i) {
		int k=inputArray.length-i;
		inputArray[k-2] = inputArray[k-2] + inputArray[k-1];
	}
	
	/*
	 * precondition: get data matrix
	 * postcondition: trace Huffman code for each element
	 */
	private static void traceHuffmanCodingResult() {
		int k, codingColumnNum;
		spanHuffmanCodeResultArray();
		//x0, x1, x2,...
		for(k=0;k<=codingMatrix.length-1;k++) {
			codingColumnNum = checkColumnForCodingSignal(k);
			startCoding(k,codingColumnNum);
		}
	}
	
	//create space for reserving coding result
	private static void spanHuffmanCodeResultArray() {
		outputArrayOfHuffmanCode = new int[codingMatrix.length][codingMatrix.length-1];
		//initializing
		int i,j;
		//caution: i<=codingMatrix.length-2 for column number
		for(i=0;i<=codingMatrix.length-1;i++) {
			for(j=0;j<=codingMatrix.length-2;j++) {
				outputArrayOfHuffmanCode[i][j] = -9;//for marking
			}
		}
	}
	
	/*
	 * precondition: get data matrix
	 * postcondition: get the column number that starts Huffman coding
	 */
	private static int checkColumnForCodingSignal(int xNum) {
		int i,j,columnNum=0,m=codingMatrix.length;
		x = codingMatrix[xNum][0];
		//column check
		for(j=0;j<=codingMatrix.length-1;j++) {
			//row check
			for(i=0;i<=m-1;i++) {
				if(x == codingMatrix[i][j]) {
					//update column number
					columnNum = j;
					//check next column
					i = m;
					m--;
				}
				//no matching element in this column, end checking
				else if((i == m-1)&&(x != codingMatrix[m-1][j])) {
					j = codingMatrix.length;
				}
			}
		}
		return columnNum;
	}
	
	/*
	 * precondition: get the column number that starts Huffman coding
	 * postcondition: complete Huffman coding
	 */
	private static void startCoding(int xNum, int columnNum) {
		int m=codingMatrix.length,t=0;
		while(columnNum != m-1) {
			if((m-columnNum>=3)&&(x == codingMatrix[m-columnNum-3][columnNum])&&(x == codingMatrix[m-columnNum-2][columnNum])) {
				columnNum++;
			}
			else if(x == codingMatrix[m-columnNum-1][columnNum]) {
				outputArrayOfHuffmanCode[xNum][t] = 0;
				//next reserving place
				t++;
				//update x
				x = codingMatrix[m-columnNum-2][columnNum] + codingMatrix[m-columnNum-1][columnNum];
				//next column
				columnNum++;
			}
			else if(x == codingMatrix[m-columnNum-2][columnNum]) {
				outputArrayOfHuffmanCode[xNum][t] = 1;
				t++;
				x = codingMatrix[m-columnNum-2][columnNum] + codingMatrix[m-columnNum-1][columnNum];
				columnNum++;
			}
			else {
				columnNum++;
			}
		}
	}
	
	/*
	 * precondition: get data matrix info
	 * postcondition: display data matrix
	 */
	private static void showDataMatrix() {
		System.out.println("");
		System.out.println("Data matrix:");
		int i, j, m=inputArray.length;
		for(i=0;i<=inputArray.length-1;i++) {
			System.out.print("x" + i + " ");
			for(j=0;j<=m-1;j++) {
				System.out.print(codingMatrix[i][j] + " ");
			}
			m--;
			System.out.println("");
		}
	}
	
	/*
	 * precondition: get coding info
	 * postcondition: show coding result of each element
	 */
	private static void showHuffmanCode() {
		System.out.println("");
		System.out.println("Huffman code:");
		int i,j;
		//caution: i<=codingMatrix.length-2
		for(i=0;i<=codingMatrix.length-1;i++) {
			System.out.print("x" + i + " ");
			//for reverse displaying
			for(j=codingMatrix.length-2;j>=0;j--) {
				if(outputArrayOfHuffmanCode[i][j] != -9) {
					System.out.print(outputArrayOfHuffmanCode[i][j] + " ");
				}
			}
			System.out.println("");
		}
	}
}
